package com.eduard.service;

import java.util.List;

import com.eduard.entity.dto.ProjectDTO;

public interface ProjectService {

	ProjectDTO addProject(ProjectDTO projectDTO);

	List<ProjectDTO> getProjects();

	ProjectDTO getProjectByProjectKey(String projectKey);

}
