package com.eduard.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	@Transactional
	@Override
	public List<IssueDTO> getIssues(int projectId) {

		List<Issue> issues = issueRepository.getIssues(projectId);
		List<IssueDTO> issuesDTO = new ArrayList<>();
		for (Issue issue : issues) {
			issuesDTO.add(new DozerBeanMapper().map(issue, IssueDTO.class));
		}
		return issuesDTO;

	}

	@Transactional
	@Override
	public TreeMap<String, Map<Integer, Integer>> getCreatedDates() {

		List<Issue> issues = issueRepository.getCreatedDates();

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
		return datesMap;

	}

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

}
