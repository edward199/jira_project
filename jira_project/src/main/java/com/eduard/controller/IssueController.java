package com.eduard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduard.entity.dto.IssueRequestDTO;
import com.eduard.entity.dto.IssueResponseDTO;
import com.eduard.service.IssueService;

@Controller
@RequestMapping("/project/issue")
public class IssueController {

	private IssueService issueService;

	/*
	 * @InitBinder private void dateBinder(WebDataBinder binder) { // The date
	 * format to parse or output your dates
	 * 
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	 * 
	 * // Create a new CustomDateEditor CustomDateEditor editor = new
	 * CustomDateEditor(dateFormat, true);
	 * 
	 * // Register it as custom editor for the Date type
	 * binder.registerCustomEditor(LocalDateTime.class, editor); }
	 */

	@Autowired
	public IssueController(IssueService issueService) {
		this.issueService = issueService;
	}

	@RequestMapping(value = "/{projectId}/issueList", method = RequestMethod.GET)
	public String listIssues(@PathVariable("projectId") int projectId, ModelMap model) {

		List<IssueResponseDTO> issues = issueService.getIssues(projectId);

		model.addAttribute("issues", issues);

		return "list-issues";

	}

	@RequestMapping(value = "/showAddIssueForm", method = RequestMethod.GET)
	public String showAddIssueForm(Model model) {
		IssueRequestDTO issueModel = new IssueRequestDTO();

		model.addAttribute("issue", issueModel);

		return "add-issue";
	}

	@ModelAttribute("issue")
	public IssueRequestDTO createIssueDTO() {
		return new IssueRequestDTO();
	}

	@RequestMapping(value = "/addIssue", method = RequestMethod.POST)
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
