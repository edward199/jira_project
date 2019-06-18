package com.eduard.repository;

import java.util.List;

import com.eduard.entity.Project;

public interface ProjectRepository {

	Project addProject(Project project);

	List<Project> getProjects();

	Project getProjectByProjectKey(String projectKey);

}