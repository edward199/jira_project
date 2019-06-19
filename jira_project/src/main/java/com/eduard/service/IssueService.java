package com.eduard.service;

import java.util.List;

import com.eduard.entity.dto.IssueDTO;

public interface IssueService {

	IssueDTO addIssue(IssueDTO issueDTO);

	List<IssueDTO> getIssues(int projectId);

}