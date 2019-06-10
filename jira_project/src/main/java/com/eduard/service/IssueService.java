package com.eduard.service;

import java.util.List;

import com.eduard.entity.dto.IssueRequestDTO;
import com.eduard.entity.dto.IssueResponseDTO;

public interface IssueService {

	IssueResponseDTO addIssue(IssueRequestDTO issueDTO);

	List<IssueResponseDTO> getIssues(int projectId);

}