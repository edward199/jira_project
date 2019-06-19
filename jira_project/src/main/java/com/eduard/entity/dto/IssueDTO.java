package com.eduard.entity.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.eduard.entity.IssuePriority;
import com.eduard.entity.IssueStatus;
import com.eduard.entity.IssueType;

public class IssueDTO {
	private int parentId;
	private String projectKey;
	private int issueNumber;
	private int projectId;
	private String reporter;
	private String creator;
	private String summary;
	private String description;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date created;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date updated;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date duedate;
	private int timeEstimate;
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
