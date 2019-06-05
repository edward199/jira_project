package com.eduard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduard.entity.Project;
import com.eduard.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	private ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
	public Project addProject(@RequestBody Project project) {
		return projectService.addProject(project);
	}

}
