package com.eduard.entity.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.eduard.entity.IssuePriority;
import com.eduard.entity.IssueStatus;
import com.eduard.entity.IssueType;

public class IssueDTO {
	private int parentId;

	@NotBlank(message = "Project key can't be null")
	@Size(min = 2, message = "Project key must have at least 2 characters")
	private String projectKey;

	@NotNull(message = "Issue number can't be null")
	@Min(value = 1, message = "Issue number must have at least 2 characters")
	private int issueNumber;

	@NotNull(message = "Project id can't be null")
	@Min(value = 1, message = "Project id must have at least 1 character")
	private int projectId;

	@NotBlank(message = "Reporter can't be null")
	@Size(min = 3, message = "Reporter must have at least 3 characters")
	private String reporter;

	@NotBlank(message = "Reporter can't be null")
	@Size(min = 3, message = "Reporter must have at least 3 characters")
	private String creator;

	@NotBlank(message = "Summary can't be null")
	@Size(min = 6, message = "Summary must have at least 6 characters")
	private String summary;

	@NotBlank(message = "Description can't be null")
	@Size(min = 10, message = "Description must have at least 10 characters")
	private String description;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date created;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date updated;

	@NotNull(message = "Date can't be null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date duedate;

	@NotNull(message = "Time estimate can't be null")
	private int timeEstimate;

	@NotNull(message = "Time spent can't be null")
	private int timeSpent;
	private IssueType issueType;
	private IssuePriority issuePriority;
	private IssueStatus issueStatus;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public int getTimeEstimate() {
		return timeEstimate;
	}

	public void setTimeEstimate(int timeEstimate) {
		this.timeEstimate = timeEstimate;
	}

	public int getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}

	public IssuePriority getIssuePriority() {
		return issuePriority;
	}

	public void setIssuePriority(IssuePriority issuePriority) {
		this.issuePriority = issuePriority;
	}

	public IssueStatus getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}

	@Override
	public String toString() {
		return "IssueRequestDTO [parentId=" + parentId + ", projectKey=" + projectKey + ", issueNumber=" + issueNumber
				+ ", projectId=" + projectId + ", reporter=" + reporter + ", creator=" + creator + ", summary="
				+ summary + ", description=" + description + ", created=" + created + ", updated=" + updated
				+ ", duedate=" + duedate + ", timeEstimate=" + timeEstimate + ", timeSpent=" + timeSpent
				+ ", issueType=" + issueType + ", issuePriority=" + issuePriority + ", issueStatus=" + issueStatus
				+ "]";
	}

}
