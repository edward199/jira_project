package com.eduard.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduard.entity.Issue;
import com.eduard.entity.dto.IssueDTO;
import com.eduard.repository.IssueRepository;

@Service
public class IssueServiceImpl implements IssueService {

	private IssueRepository issueRepository;

	@Autowired
	public IssueServiceImpl(IssueRepository issueRepository) {
		this.issueRepository = issueRepository;
	}

	@Transactional
	@Override
	public IssueDTO addIssue(IssueDTO issueDTO) {

		Issue issue = new DozerBeanMapper().map(issueDTO, Issue.class);
		issueRepository.addIssue(issue);
		return new DozerBeanMapper().map(issue, IssueDTO.class);

	}

	@Override
	public List<IssueDTO> getIssues(int projectId) {

		List<Issue> issues = issueRepository.getIssues(projectId);
		List<IssueDTO> issuesDTO = new ArrayList<>();
		for (Issue issue : issues) {
			issuesDTO.add(new DozerBeanMapper().map(issue, IssueDTO.class));
		}
		return issuesDTO;

	}

	@Override
	public List<IssueDTO> showIssuesAroundADate(int n, String date) {

		List<Issue> issues = issueRepository.getAllIssues();

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		TreeMap<String, Map<Integer, Integer>> datesMap = new TreeMap<>();
		for (Issue issue : issues) {
			String datee = simpleDateFormat.format(issue.getCreated());
			if (datesMap.containsKey(datee)) {
				Map<Integer, Integer> ids = datesMap.get(datee);
				ids.put(issue.getId(), 1);
				datesMap.put(datee, ids);
			} else {
				Map<Integer, Integer> ids = new HashMap<>();
				ids.put(issue.getId(), 1);
				datesMap.put(datee, ids);
			}
		}
		Set<Integer> issuesToShow = topNDays(datesMap, n, date);
		List<IssueDTO> issuesDTO = new ArrayList<>();
		for (Integer i : issuesToShow) {
			for (Issue issue : issues) {
				if (i == issue.getId()) {
					issuesDTO.add(new DozerBeanMapper().map(issue, IssueDTO.class));
					break;
				}
			}
		}
		return issuesDTO;
	}

	@Override
	public Set<Integer> topNDays(TreeMap<String, Map<Integer, Integer>> datesMap, int n, String date) {

		int leftValue = 0;
		int rightValue = 0;
		String leftKey;
		String rightKey;
		Set<Integer> issuesToShow = new HashSet<>();
		if (datesMap.containsKey(date)) {
			n = n - datesMap.get(date).size();
			issuesToShow.addAll(datesMap.get(date).keySet());
		}
		leftKey = datesMap.lowerKey(date);
		rightKey = datesMap.higherKey(date);
		while (n != 0) {
			if (leftKey != null && rightKey != null) {
				leftValue = Math.abs(differenceBetweenTwoDays(date, leftKey));
				rightValue = Math.abs(differenceBetweenTwoDays(rightKey, date));
				if (leftValue == rightValue) {
					n = n - datesMap.get(leftKey).size();
					issuesToShow.addAll(datesMap.get(leftKey).keySet());
					leftKey = datesMap.lowerKey(leftKey);
					if (n != 0) {
						n = n - datesMap.get(rightKey).size();
						issuesToShow.addAll(datesMap.get(rightKey).keySet());
						rightKey = datesMap.higherKey(rightKey);
					}
				} else if (leftValue < rightValue) {
					n = n - datesMap.get(leftKey).size();
					issuesToShow.addAll(datesMap.get(leftKey).keySet());
					leftKey = datesMap.lowerKey(leftKey);
				} else if (rightValue < leftValue) {
					n = n - datesMap.get(rightKey).size();
					issuesToShow.addAll(datesMap.get(rightKey).keySet());
					rightKey = datesMap.higherKey(rightKey);
				}
			} else if (leftKey == null) {
				while (rightKey != null && n != 0) {
					n = n - datesMap.get(rightKey).size();
					issuesToShow.addAll(datesMap.get(rightKey).keySet());
					rightKey = datesMap.higherKey(rightKey);
				}
			} else if (rightKey == null) {
				while (leftKey != null && n != 0) {
					n = n - datesMap.get(leftKey).size();
					issuesToShow.addAll(datesMap.get(leftKey).keySet());
					leftKey = datesMap.lowerKey(leftKey);
				}
			}
		}
		return issuesToShow;
	}

	public int differenceBetweenTwoDays(String date1, String date2) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		int days = 0;
		try {
			java.util.Date date3 = myFormat.parse(date1);
			java.util.Date date4 = myFormat.parse(date2);
			long diff = date3.getTime() - date4.getTime();
			days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	@Override
	public List<Integer> searchInIssues(String search, int n) {
		Map<Integer, Map<String, List<Integer>>> searchResults = new TreeMap<>(Collections.reverseOrder());
		int issueNumberCounter = 0;
		int summaryCounter = 0;
		int descriptionCounter = 0;
		List<Issue> issues = issueRepository.getAllIssues();
		String[] words = search.split(" ");
		for (Issue issue : issues) {
			issueNumberCounter = 0;
			summaryCounter = 0;
			descriptionCounter = 0;
			for (String word : words) {
				if (word.chars().allMatch(Character::isDigit)) {
					if (Integer.valueOf(word) == issue.getIssueNumber()) {
						issueNumberCounter++;
					}
				}
				if (issue.getSummary().toLowerCase().contains(word.toLowerCase())) {
					summaryCounter++;
				}
				if (issue.getDescription().toLowerCase().contains(word.toLowerCase())) {
					descriptionCounter++;
				}
			}
			if (issueNumberCounter != 0 || summaryCounter != 0 || descriptionCounter != 0) {
				Map<String, List<Integer>> priorityAndIssueId;
				if (issueNumberCounter != 0) {
					if (searchResults.containsKey(issueNumberCounter)) {
						priorityAndIssueId = searchResults.get(issueNumberCounter);
					} else {
						priorityAndIssueId = new HashMap<>();
					}
					if (priorityAndIssueId.containsKey("H")) {
						List<Integer> issuesId = priorityAndIssueId.get("H");
						issuesId.add(issue.getId());
						priorityAndIssueId.put("H", issuesId);
					} else {
						List<Integer> issuesId = new ArrayList<>();
						issuesId.add(issue.getId());
						priorityAndIssueId.put("H", issuesId);
					}
					searchResults.put(issueNumberCounter, priorityAndIssueId);
				}
				if (summaryCounter != 0) {
					if (searchResults.containsKey(summaryCounter)) {
						priorityAndIssueId = searchResults.get(summaryCounter);
					} else {
						priorityAndIssueId = new HashMap<>();
					}
					if (priorityAndIssueId.containsKey("M")) {
						List<Integer> issuesId = priorityAndIssueId.get("M");
						issuesId.add(issue.getId());
						priorityAndIssueId.put("M", issuesId);
					} else {
						List<Integer> issuesId = new ArrayList<>();
						issuesId.add(issue.getId());
						priorityAndIssueId.put("M", issuesId);
					}
					searchResults.put(summaryCounter, priorityAndIssueId);
				}
				if (descriptionCounter != 0) {
					if (searchResults.containsKey(descriptionCounter)) {
						priorityAndIssueId = searchResults.get(descriptionCounter);
					} else {
						priorityAndIssueId = new HashMap<>();
					}
					if (priorityAndIssueId.containsKey("L")) {
						List<Integer> issuesId = priorityAndIssueId.get("L");
						issuesId.add(issue.getId());
						priorityAndIssueId.put("L", issuesId);
					} else {
						List<Integer> issuesId = new ArrayList<>();
						issuesId.add(issue.getId());
						priorityAndIssueId.put("L", issuesId);
					}
					searchResults.put(descriptionCounter, priorityAndIssueId);
				}
				System.out.println("Uraa");
			}
		}
		List<Integer> issuesToShow = new ArrayList<>();
		for (Map.Entry<Integer, Map<String, List<Integer>>> entry : searchResults.entrySet()) {
			Map<String, List<Integer>> priorityAndIssueId = entry.getValue();
			if (priorityAndIssueId.containsKey("H")) {
				List<Integer> issuesCandidateForShowing = priorityAndIssueId.get("H");
				for (Integer i : issuesCandidateForShowing) {
					if (n != 0) {
						issuesToShow.add(i);
						n--;
					} else {
						break;
					}

				}
			}
//			if (n == 0) {
//				break;
//			} else {
//				if (priorityAndIssueId.containsKey("M")) {
//					List<Integer> issuesCandidateForShowing = priorityAndIssueId.get("M");
//					for (Integer i : issuesCandidateForShowing) {
//						if (n != 0) {
//							issuesToShow.add(i);
//							n--;
//						} else {
//							break;
//						}
//
//					}
//				}
//			}
		}
		return issuesToShow;
	}
}
