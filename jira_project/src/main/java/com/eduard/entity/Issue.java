package com.eduard.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "issue")
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "parent_id")
	private int parentId;

	@Column(name = "project_key")
	private String projectKey;

	@Column(name = "issue_number")
	private int issueNumber;

	@Column(name = "project_id")
	private int projectId;

	@Column(name = "reporter")
	private String reporter;

	@Column(name = "creator")
	private String creator;

	@Column(name = "summary")
	private String summary;

	@Column(name = "description")
	private String description;

	@Column(name = "created")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date created;

	@Column(name = "updated")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date updated;

	@Column(name = "duedate")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date duedate;

	@Column(name = "time_estimate")
	private int timeEstimate;

	@Column(name = "time_spent")
	private int timeSpent;

	@OneToOne
	@JoinColumn(name = "issue_type_id")
	private IssueType issueType;

	@OneToOne
	@JoinColumn(name = "issue_priority_id")
	private IssuePriority issuePriority;

	@OneToOne
	@JoinColumn(name = "issue_status_id")
	private IssueStatus issueStatus;

	public int getId() {
		return id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public void setIssuePriority(IssuePriority issuePriority) {
		this.issuePriority = issuePriority;
	}

	public void setId(int id) {
		this.id = id;
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

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
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

	public IssuePriority getIssuePriority() {
		return issuePriority;
	}

	public void setPriority(IssuePriority issuePriority) {
		this.issuePriority = issuePriority;
	}

	public IssueStatus getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
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

	@Override
	public String toString() {
		return "Issue [id=" + id + ", parentId=" + parentId + ", projectKey=" + projectKey + ", issueNumber="
				+ issueNumber + ", projectId=" + projectId + ", reporter=" + reporter + ", creator=" + creator
				+ ", summary=" + summary + ", description=" + description + ", created=" + created + ", updated="
				+ updated + ", duedate=" + duedate + ", timeEstimate=" + timeEstimate + ", timeSpent=" + timeSpent
				+ ", issueType=" + issueType + ", issuePriority=" + issuePriority + ", issueStatus=" + issueStatus
				+ "]";
	}

}
