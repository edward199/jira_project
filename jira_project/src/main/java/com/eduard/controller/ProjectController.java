package com.eduard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduard.entity.dto.ProjectDTO;
import com.eduard.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	private ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping(value = "/list")
	public String listProjects(ModelMap model) {
		List<ProjectDTO> projects = projectService.getProjects();

		model.addAttribute("projects", projects);

		return "list-projects";

	}

	@GetMapping(value = "/{projectKey}")
	public String listProject(ModelMap model, @PathVariable("projectKey") String projectKey) {

		ProjectDTO project = projectService.getProjectByProjectKey(projectKey);

		model.addAttribute("project", project);

		return "list-project";

	}

	@GetMapping(value = "/showAddProjectForm")
	public String showAddProjectForm(Model model) {
		ProjectDTO projectModel = new ProjectDTO();

		model.addAttribute("project", projectModel);

		return "add-project";
	}

	@ModelAttribute("project")
	public ProjectDTO createProjectDTO() {
		return new ProjectDTO();
	}

	@PostMapping(value = "/addProject")
	public String addProject(@ModelAttribute("project") @Valid ProjectDTO projectDTO, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "add-project";
		}
		model.addAttribute("description", projectDTO.getDescription());
		model.addAttribute("leader", projectDTO.getLeader());
		model.addAttribute("projectKey", projectDTO.getProjectKey());
		model.addAttribute("projectName", projectDTO.getProjectName());
		model.addAttribute("projectType", projectDTO.getProjectType());
		model.addAttribute("url", projectDTO.getUrl());
		projectService.addProject(projectDTO);
		return "redirect:/project/list";
	}

}
