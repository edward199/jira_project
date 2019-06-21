package com.eduard.service;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.eduard.entity.Issue;
import com.eduard.entity.dto.IssueDTO;
import com.eduard.repository.IssueRepository;

public class TestIssuesAroundADate {

	@Mock
	private IssueRepository issueRepository;
	private IssueService issueService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		issueService = new IssueServiceImpl(issueRepository);
	}

	@Test
	public void getIssuesByADateTest() {
		List<Issue> issues = new ArrayList<>();

		Issue issue1 = new Issue(3, 2, "BCHM", 23, 3, "Edi", "George", "Spring MVC", "Model-View-Controller",
				Date.valueOf("2019-06-11"), Date.valueOf("2019-06-11"), Date.valueOf("2019-06-12"), 200, 2);
		Issue issue2 = new Issue(9, 8, "JRP", 14, 1, "Cristi", "Edi", "Nuuuuuuuuu", "nUUUUUUUUUUUU",
				Date.valueOf("2019-06-13"), Date.valueOf("2019-06-13"), Date.valueOf("2019-06-18"), 100, 5);
		Issue issue3 = new Issue(11, 9, "EXL", 56, 3, "Eduard", "Gabriel", "Testing", "Jira Project Testing",
				Date.valueOf("2019-06-15"), Date.valueOf("2019-06-15"), Date.valueOf("2019-06-25"), 70, 20);
		issues.add(issue1);
		issues.add(issue2);
		issues.add(issue3);

		Mockito.when(issueRepository.getAllIssues()).thenReturn(issues);

		/* Mockito.when().thenReturn(issues); */

		List<IssueDTO> expected = new ArrayList<IssueDTO>();

		for (Issue issue : issues) {
			expected.add(new DozerBeanMapper().map(issue, IssueDTO.class));
		}

		List<IssueDTO> result = issueService.showIssuesAroundADate(3, "2019-06-12");

		assertEquals(expected, result);
	}

}
