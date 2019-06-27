package com.gabriel;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.google.common.collect.Sets;

public class SearchIssue {

	public static void main(String[] args) {

		int n = 6;
		Map<Integer, Map<String, Set<Integer>>> mapWithIssues = formMap();
		getIssuesIdToShow(mapWithIssues, n);
	}

	private static Map<Integer, Map<String, Set<Integer>>> formMap() {
		Map<Integer, Map<String, Set<Integer>>> searchResults = new TreeMap<>(Collections.reverseOrder());
		Map<String, Set<Integer>> toAdd = new HashMap<>();
		populateMap(searchResults, toAdd);
		System.out.println(searchResults);
		return searchResults;
	}

	private static void populateMap(Map<Integer, Map<String, Set<Integer>>> searchResults,
			Map<String, Set<Integer>> toAdd) {
		Set<Integer> issuesId1 = new HashSet<>();
		issuesId1.add(22);
		issuesId1.add(23);
		issuesId1.add(24);
		issuesId1.add(25);
		toAdd.put("M", issuesId1);
		Set<Integer> issuesId2 = new HashSet<>();
		issuesId2.add(23);
		issuesId2.add(24);
		issuesId2.add(26);
		toAdd.put("L", issuesId2);
		searchResults.put(3, toAdd);
		toAdd = new HashMap<>();
		Set<Integer> issuesId3 = new HashSet<>();
		issuesId3.add(22);
		issuesId3.add(25);
		toAdd.put("L", issuesId3);
		issuesId3 = new HashSet<>();
		issuesId3.add(26);
		toAdd.put("M", issuesId3);
		searchResults.put(2, toAdd);
		toAdd = new HashMap<>();
		Set<Integer> issuesId4 = new HashSet<>();
		issuesId4.add(23);
		issuesId4.add(25);
		issuesId4.add(26);
		toAdd.put("H", issuesId4);
		searchResults.put(1, toAdd);
	}

	public static void getIssuesIdToShow(Map<Integer, Map<String, Set<Integer>>> mapWithIssues, int n) {
		Set<Integer> issuesToShow = new LinkedHashSet<>();
		for (Map.Entry<Integer, Map<String, Set<Integer>>> entryH : mapWithIssues.entrySet()) {
			Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsH = entryH.getValue();
			if (n != 0) {
				if (mapWithPriorityAndIssuesIdsH.containsKey("H")) {
					if (mapWithPriorityAndIssuesIdsH.get("H").size() == 1) {
						issuesToShow.addAll(mapWithPriorityAndIssuesIdsH.get("H"));
						n--;
					} else {
						if (n != 0) {
							if (mapWithPriorityAndIssuesIdsH.get("H").size() > 1) {
								Set<Integer> issuesWithH = mapWithPriorityAndIssuesIdsH.get("H");
								for (Map.Entry<Integer, Map<String, Set<Integer>>> entryM : mapWithIssues.entrySet()) {
									Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsM = entryM.getValue();
									if (mapWithPriorityAndIssuesIdsM.containsKey("M")) {
										if (mapWithPriorityAndIssuesIdsM.get("M").size() == 1) {
											issuesToShow.addAll(mapWithPriorityAndIssuesIdsM.get("M"));
											n--;
										} else {
											if (n != 0) {
												if (mapWithPriorityAndIssuesIdsM.get("M").size() > 1) {
													Set<Integer> issuesWithM = mapWithPriorityAndIssuesIdsM.get("M");
													Set<Integer> issuesToSearch = Sets.intersection(issuesWithM,
															issuesWithH);
													if (issuesToSearch != null) {
														for (Map.Entry<Integer, Map<String, Set<Integer>>> entryL : mapWithIssues
																.entrySet()) {
															Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsL = entryL
																	.getValue();
															if (mapWithPriorityAndIssuesIdsL.containsKey("L")) {
																Set<Integer> issuesWithL = mapWithPriorityAndIssuesIdsL
																		.get("L");

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
											} else {
												break;
											}
										}
									}
								}
							}
						} else {
							break;
						}
					}
				}
			} else {
				break;
			}
		}
		if (n != 0) {
			for (Map.Entry<Integer, Map<String, Set<Integer>>> entryM : mapWithIssues.entrySet()) {
				Map<String, Set<Integer>> mapWithPriorityAndIssuesIdsM = entryM.getValue();
				if (mapWithPriorityAndIssuesIdsM.containsKey("M")) {
					if (mapWithPriorityAndIssuesIdsM.get("M").size() == 1) {
						issuesToShow.addAll(mapWithPriorityAndIssuesIdsM.get("M"));
						n--;
					} else {
						if (n != 0) {
							if (mapWithPriorityAndIssuesIdsM.get("M").size() > 1) {
								Set<Integer> issuesWithM = mapWithPriorityAndIssuesIdsM.get("M");
								for (Map.Entry<Integer, Map<String, Set<Integer>>> entryL : mapWithIssues.entrySet()) {
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
							}
						} else {
							break;
						}
					}
				}
			}
		}
		System.out.println("Exact");
		System.out.println(issuesToShow);
	}
}
