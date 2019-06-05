package com.eduard.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduard.entity.Project;
import com.eduard.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	private ProjectRepository projectRepository;
	
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}


	@Transactional
	@Override
	public Project addProject(Project project) {
		return projectRepository.addProject(project);
	}

	
	
}
