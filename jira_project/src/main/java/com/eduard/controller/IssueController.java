package com.eduard.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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

import com.eduard.entity.dto.IssueDTO;
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

		List<IssueDTO> issues = issueService.getIssues(projectId);

		model.addAttribute("issues", issues);

		return "list-issues";

	}

	@GetMapping(value = "/showAddIssueForm")
	public String showAddIssueForm(Model model) {
		IssueDTO issueModel = new IssueDTO();

		model.addAttribute("issue", issueModel);

		return "add-issue";
	}

	@ModelAttribute("issue")
	public IssueDTO createIssueDTO() {
		return new IssueDTO();
	}

	@PostMapping(value = "/addIssue")
	public String addIssue(@ModelAttribute("issue") @Valid IssueDTO issueDTO, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "add-issue";
		}

		model.addAttribute("parentId", issueDTO.getParentId());
		model.addAttribute("projectKey", issueDTO.getProjectKey());
		model.addAttribute("issueNumber", issueDTO.getIssueNumber());
		model.addAttribute("projectId", issueDTO.getProjectId());
		model.addAttribute("reporter", issueDTO.getReporter());
		model.addAttribute("creator", issueDTO.getCreator());
		model.addAttribute("summary", issueDTO.getSummary());
		model.addAttribute("description", issueDTO.getDescription());
		model.addAttribute("duedate", issueDTO.getDuedate());
		model.addAttribute("timeEstimate", issueDTO.getTimeEstimate());
		model.addAttribute("timeSpent", issueDTO.getTimeSpent());
		issueService.addIssue(issueDTO);
		return "redirect:/project/issue/{projectId}/issueList";
	}

	@GetMapping(value = "/createdDays")
	public String createdDays() {
		TreeMap<String, Map<Integer, Integer>> issues = issueService.getCreatedDates();
		Set<Integer> issuesToShow = issueService.topNDays(issues, 6, "2019-06-12");
		return "created-days";
	}
}
