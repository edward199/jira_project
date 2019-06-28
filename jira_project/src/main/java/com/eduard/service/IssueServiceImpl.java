package com.eduard.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
import com.google.common.collect.Sets;

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
	public List<IssueDTO> searchInIssues(String search, int n) {
		List<Issue> issues = issueRepository.getAllIssues();
		List<IssueDTO> issuesDTO = new ArrayList<>();
		Set<Integer> issuesToShow = new LinkedHashSet<>();
		Map<Integer, Map<String, Set<Integer>>> mappedIssues = getMapOfIssues(search, issues);
		n = searchForHs(mappedIssues, n, issuesToShow);
		if (n != 0) {
			n = searchForMs(mappedIssues, n, issuesToShow);
		}
		if (n != 0) {
			n = searchForLs(mappedIssues, n, issuesToShow);
		}
		Iterator<Integer> setIterator = issuesToShow.iterator();
		while (setIterator.hasNext()) {
			int value = setIterator.next();
			for (Issue issue : issues) {
				if (issue.getId() == value) {
					issuesDTO.add(new DozerBeanMapper().map(issue, IssueDTO.class));
				}
			}
		}
		return issuesDTO;
	}

	@Override
	public Map<Integer, Map<String, Set<Integer>>> getMapOfIssues(String search, List<Issue> issues) {
		Map<Integer, Map<String, Set<Integer>>> searchResults = new TreeMap<>(Collections.reverseOrder());
		int issueNumberCounter = 0;
		int summaryCounter = 0;
		int descriptionCounter = 0;
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
				Map<String, Set<Integer>> priorityAndIssueId;
				if (issueNumberCounter != 0) {
					if (searchResults.containsKey(issueNumberCounter)) {
						priorityAndIssueId = searchResults.get(issueNumberCounter);
					} else {
						priorityAndIssueId = new HashMap<>();
					}
					if (priorityAndIssueId.containsKey("H")) {
						Set<Integer> issuesId = priorityAndIssueId.get("H");
						issuesId.add(issue.getId());
						priorityAndIssueId.put("H", issuesId);
					} else {
						Set<Integer> issuesId = new HashSet<>();
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
						Set<Integer> issuesId = priorityAndIssueId.get("M");
						issuesId.add(issue.getId());
						priorityAndIssueId.put("M", issuesId);
					} else {
						Set<Integer> issuesId = new HashSet<>();
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
						Set<Integer> issuesId = priorityAndIssueId.get("L");
						issuesId.add(issue.getId());
						priorityAndIssueId.put("L", issuesId);
					} else {
						Set<Integer> issuesId = new HashSet<>();
						issuesId.add(issue.getId());
						priorityAndIssueId.put("L", issuesId);
					}
					searchResults.put(descriptionCounter, priorityAndIssueId);
				}
			}
		}
		return searchResults;
	}

	public int searchForHs(Map<Integer, Map<String, Set<Integer>>> mappedIssues, int n, Set<Integer> issuesToShow) {
		for (Map.Entry<Integer, Map<String, Set<Integer>>> entryH : mappedIssues.entrySet()) {
			Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsH = entryH.getValue();
			if (mapWithPriorityAndIssuesIdsH.containsKey("H")) {
				if (mapWithPriorityAndIssuesIdsH.get("H").size() == 1) {
					Set<Integer> singleSet = mapWithPriorityAndIssuesIdsH.get("H");
					Iterator<Integer> setIt = singleSet.iterator();
					if (n != 0) {
						if (!issuesToShow.contains(setIt.next())) {
							issuesToShow.addAll(mapWithPriorityAndIssuesIdsH.get("H"));
							n--;
						}
					} else {
						break;
					}
				} else {
					if (mapWithPriorityAndIssuesIdsH.get("H").size() > 1) {
						Set<Integer> issuesWithH = mapWithPriorityAndIssuesIdsH.get("H");
						for (Map.Entry<Integer, Map<String, Set<Integer>>> entryM : mappedIssues.entrySet()) {
							Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsM = entryM.getValue();
							if (mapWithPriorityAndIssuesIdsM.containsKey("M")) {
								if (mapWithPriorityAndIssuesIdsM.get("M").size() == 1) {
									Set<Integer> singleSet = mapWithPriorityAndIssuesIdsM.get("M");
									Iterator<Integer> setIt = singleSet.iterator();
									if (n != 0 && !(issuesWithH.isEmpty())) {
										int value = setIt.next();
										if (!issuesToShow.contains(value)) {
											issuesToShow.addAll(mapWithPriorityAndIssuesIdsM.get("M"));
											issuesWithH.remove(value);
											n--;
										}
									} else {
										break;
									}
								} else {
									if (mapWithPriorityAndIssuesIdsM.get("M").size() > 1) {
										Set<Integer> issuesWithM = mapWithPriorityAndIssuesIdsM.get("M");
										Set<Integer> issuesToSearch = Sets.intersection(issuesWithM, issuesWithH);
										if (issuesToSearch != null) {
											for (Map.Entry<Integer, Map<String, Set<Integer>>> entryL : mappedIssues
													.entrySet()) {
												Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsL = entryL
														.getValue();
												if (mapWithPriorityAndIssuesIdsL.containsKey("L")) {
													Set<Integer> issuesWithL = mapWithPriorityAndIssuesIdsL.get("L");

													for (Integer iL : issuesWithL) {
														Iterator<Integer> itrH = issuesToSearch.iterator();
														if (n != 0) {
															while (itrH.hasNext()) {
																int value = itrH.next();
																if (iL == value) {
																	if (!issuesToShow.contains(iL)) {
																		issuesToShow.add(iL);
																		issuesWithH.remove(value);
																		n--;
																	}
																}
															}
														} else {
															break;
														}
													}
												}
											}
										}
									}
								}
							}
						}
						Iterator<Integer> issuesH = issuesWithH.iterator();
						while (issuesH.hasNext()) {
							if (n != 0) {
								int value = issuesH.next();
								if (!issuesToShow.contains(value)) {
									issuesToShow.add(value);
									n--;
								}
							} else {
								break;
							}
						}
					}
				}

			}
		}
		return n;
	}

	public int searchForMs(Map<Integer, Map<String, Set<Integer>>> mappedIssues, int n, Set<Integer> issuesToShow) {
		for (Map.Entry<Integer, Map<String, Set<Integer>>> entryM : mappedIssues.entrySet()) {
			Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsM = entryM.getValue();
			if (mapWithPriorityAndIssuesIdsM.containsKey("M")) {
				if (mapWithPriorityAndIssuesIdsM.get("M").size() == 1) {
					Set<Integer> singleSet = mapWithPriorityAndIssuesIdsM.get("M");
					Iterator<Integer> setIt = singleSet.iterator();
					if (n != 0) {
						if (!issuesToShow.contains(setIt.next())) {
							issuesToShow.addAll(mapWithPriorityAndIssuesIdsM.get("M"));
							n--;
						}
					} else {
						break;
					}
				} else {
					if (mapWithPriorityAndIssuesIdsM.get("M").size() > 1) {
						Set<Integer> issuesWithM = mapWithPriorityAndIssuesIdsM.get("M");
						for (Map.Entry<Integer, Map<String, Set<Integer>>> entryL : mappedIssues.entrySet()) {
							Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsL = entryL.getValue();
							if (mapWithPriorityAndIssuesIdsL.containsKey("L")) {
								Set<Integer> issuesWithL = mapWithPriorityAndIssuesIdsL.get("L");

								for (Integer iL : issuesWithL) {
									Iterator<Integer> itrM = issuesWithM.iterator();
									if (n != 0) {
										while (itrM.hasNext()) {
											int value = itrM.next();
											if (iL == value) {
												if (!issuesToShow.contains(iL)) {
													issuesToShow.add(iL);
													itrM.remove();
													n--;
												}
											}
										}
									} else {
										break;
									}
								}
							}
						}
						Iterator<Integer> issuesM = issuesWithM.iterator();
						while (issuesM.hasNext()) {
							if (n != 0) {
								int value = issuesM.next();
								if (!issuesToShow.contains(value)) {
									issuesToShow.add(value);
									n--;
								}
							} else {
								break;
							}
						}
					}
				}
			}
		}
		return n;
	}

	public int searchForLs(Map<Integer, Map<String, Set<Integer>>> mappedIssues, int n, Set<Integer> issuesToShow) {
		for (Map.Entry<Integer, Map<String, Set<Integer>>> entryL : mappedIssues.entrySet()) {
			Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsL = entryL.getValue();
			if (mapWithPriorityAndIssuesIdsL.containsKey("L")) {
				Set<Integer> issuesWithL = mapWithPriorityAndIssuesIdsL.get("L");
				Iterator<Integer> itrL = issuesWithL.iterator();
				while (itrL.hasNext()) {
					if (n != 0) {
						int value = itrL.next();
						if (!issuesToShow.contains(value)) {
							issuesToShow.add(value);
							itrL.remove();
							n--;
						}
					} else {
						break;
					}
				}
			}
		}
		return n;
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
}
