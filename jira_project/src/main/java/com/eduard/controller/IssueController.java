package com.eduard.controller;

import java.util.List;

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

import com.eduard.entity.dto.IssueRequestDTO;
import com.eduard.entity.dto.IssueResponseDTO;
import com.eduard.service.IssueService;

@Controller
@RequestMapping("/project/issue")
public class IssueController {

	private IssueService issueService;

	@Autowired
	public IssueController(IssueService issueService) {
		this.issueService = issueService;
	}

	@GetMapping(value = "/{projectId}/issueList")
	public String listIssues(@PathVariable("projectId") int projectId, ModelMap model) {

		List<IssueResponseDTO> issues = issueService.getIssues(projectId);

		model.addAttribute("issues", issues);

		return "list-issues";

	}

	@GetMapping(value = "/showAddIssueForm")
	public String showAddIssueForm(Model model) {
		IssueRequestDTO issueModel = new IssueRequestDTO();

		model.addAttribute("issue", issueModel);

		return "add-issue";
	}

	@ModelAttribute("issue")
	public IssueRequestDTO createIssueDTO() {
		return new IssueRequestDTO();
	}

	@PostMapping(value = "/addIssue")
	public String addIssue(@ModelAttribute("issue") IssueRequestDTO issueRequestDTO, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		model.addAttribute("parentId", issueRequestDTO.getParentId());
		model.addAttribute("projectKey", issueRequestDTO.getProjectKey());
		model.addAttribute("issueNumber", issueRequestDTO.getIssueNumber());
		model.addAttribute("projectId", issueRequestDTO.getProjectId());
		model.addAttribute("reporter", issueRequestDTO.getReporter());
		model.addAttribute("creator", issueRequestDTO.getCreator());
		model.addAttribute("summary", issueRequestDTO.getSummary());
		model.addAttribute("description", issueRequestDTO.getDescription());
		model.addAttribute("duedate", issueRequestDTO.getDuedate());
		model.addAttribute("timeEstimate", issueRequestDTO.getTimeEstimate());
		model.addAttribute("timeSpent", issueRequestDTO.getTimeSpent());
		issueService.addIssue(issueRequestDTO);
		return "redirect:/project/issue/{projectId}/issueList";
	}
}
