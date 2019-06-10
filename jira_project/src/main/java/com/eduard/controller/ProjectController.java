package com.eduard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listProjects(ModelMap model) {
		List<ProjectDTO> projects = projectService.getProjects();

		model.addAttribute("projects", projects);

		return "list-projects";

	}

	@RequestMapping(value = "/showAddProjectForm", method = RequestMethod.GET)
	public String showAddProjectForm(Model model) {
		ProjectDTO projectModel = new ProjectDTO();

		model.addAttribute("project", projectModel);

		return "add-project";
	}

	@ModelAttribute("project")
	public ProjectDTO createProjectDTO() {
		return new ProjectDTO();
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public String addProject(@ModelAttribute("project") ProjectDTO projectDTO, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
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
