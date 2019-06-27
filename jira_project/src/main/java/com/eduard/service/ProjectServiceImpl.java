package com.eduard.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduard.entity.Project;
import com.eduard.entity.dto.ProjectDTO;
import com.eduard.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepository;

	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Transactional
	@Override
	public ProjectDTO addProject(ProjectDTO projectDTO) {
		Project project = new DozerBeanMapper().map(projectDTO, Project.class);
		projectRepository.addProject(project);
		return projectDTO;
	}

	@Override
	public List<ProjectDTO> getProjects() {
		List<Project> projects = projectRepository.getProjects();
		List<ProjectDTO> projectsDTO = new ArrayList<>();
		for (Project project : projects) {
			projectsDTO.add(new DozerBeanMapper().map(project, ProjectDTO.class));
		}
		return projectsDTO;
	}

	@Override
	public ProjectDTO getProjectByProjectKey(String projectKey) {

		Project project = projectRepository.getProjectByProjectKey(projectKey);

		return new DozerBeanMapper().map(project, ProjectDTO.class);

	}

}
