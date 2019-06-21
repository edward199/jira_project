package com.eduard.service;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.eduard.entity.Issue;
import com.eduard.repository.IssueRepository;

public class TestIssueService {

	@Mock
	IssueRepository issueRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIssuesForAProjectTest() {

		List<Issue> issues = new ArrayList<>();

		Issue issue = new Issue(3, 2, "BCHM", 23, 3, "Edi", "George", "Spring MVC", "Model-View-Controller",
				Date.valueOf("2019-06-11"), Date.valueOf("2019-06-11"), Date.valueOf("2019-06-12"), 200, 2);

		issues.add(issue);

		Mockito.when(issueRepository.getIssues(3)).thenReturn(issues);

		Issue resultIssue = issueRepository.getIssues(3).get(0);

		// Mockito.when(resultIssue.getProjectKey()).thenReturn("BCHM");

		assertEquals("BCHM", resultIssue.getProjectKey());
	}

}
