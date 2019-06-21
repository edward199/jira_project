package com.eduard.repository;

import java.util.List;

import com.eduard.entity.Issue;

public interface IssueRepository {

	Issue addIssue(Issue issue);

	List<Issue> getIssues(int projectId);

	List<Issue> getAllIssues();
}