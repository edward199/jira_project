package com.eduard.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.eduard.entity.dto.IssueDTO;

public interface IssueService {

	IssueDTO addIssue(IssueDTO issueDTO);

	List<IssueDTO> getIssues(int projectId);

	public List<IssueDTO> showIssuesAroundADate(int n, String date);

	public Set<Integer> topNDays(TreeMap<String, Map<Integer, Integer>> datesMap, int n, String date);

}