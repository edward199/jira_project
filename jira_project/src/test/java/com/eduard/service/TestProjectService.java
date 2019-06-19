package com.eduard.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.eduard.entity.Project;
import com.eduard.repository.ProjectRepository;

public class TestProjectService {

	@Mock
	ProjectRepository projectRepository;

	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void getAllProjectTest() {

		List<Project> projects = new ArrayList<>();
		Project project1 = new Project("DemoJira", "Edi", "JRP", "JiraProject", "Yes", "www.jira.com");
		Project project2 = new Project("Internship Project", "George", "BCHM", "Internal Project", "Internal",
				"www.jira_project.com");
		projects.add(project1);
		projects.add(project2);

		Mockito.when(projectRepository.getProjects()).thenReturn(projects);

		assertEquals(2, projects.size());

	}

	@Test
	public void getProjectByProjectKeyTest() {

		Project resultProject = Mockito.mock(Project.class);

		Mockito.when(projectRepository.getProjectByProjectKey("BCHM")).thenReturn(resultProject);

		Mockito.when(resultProject.getProjectKey()).thenReturn("BCHM");

		assertEquals("BCHM", resultProject.getProjectKey());

	}
}
