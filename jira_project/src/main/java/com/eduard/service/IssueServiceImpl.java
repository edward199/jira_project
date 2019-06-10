package com.eduard.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduard.entity.Issue;
import com.eduard.entity.dto.IssueRequestDTO;
import com.eduard.entity.dto.IssueResponseDTO;
import com.eduard.repository.IssueRepository;

@Service
public class IssueServiceImpl implements IssueService {

	private IssueRepository issueRepository;

	@Autowired
	public IssueServiceImpl(IssueRepository issueRepository) {
		this.issueRepository = issueRepository;
	}

	@Transactional
	@Override
	public IssueResponseDTO addIssue(IssueRequestDTO issueDTO) {

		Issue issue = new DozerBeanMapper().map(issueDTO, Issue.class);
		issue.setCreated(Timestamp.valueOf(LocalDateTime.now()));
		issue.setUpdated(Timestamp.valueOf(LocalDateTime.now()));
		issueRepository.addIssue(issue);
		return new DozerBeanMapper().map(issue, IssueResponseDTO.class);

	}

	@Transactional
	@Override
	public List<IssueResponseDTO> getIssues(int projectId) {

		List<Issue> issues = issueRepository.getIssues(projectId);
		List<IssueResponseDTO> issuesDTO = new ArrayList<>();
		for (Issue issue : issues) {
			issuesDTO.add(new DozerBeanMapper().map(issue, IssueResponseDTO.class));
		}
		return issuesDTO;

	}

}
