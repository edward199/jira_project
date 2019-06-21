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
	private int id;

	private int parentId;

	@NotBlank(message = "Project key can't be null")
	@Size(min = 2, message = "Project key must have at least 2 characters")
	private String projectKey;

	@NotNull(message = "Issue number can't be null")
	@Min(value = 1, message = "Issue number can't be 0")
	private int issueNumber;

	@NotNull(message = "Project id can't be null")
	@Min(value = 1, message = "Project id can't be 0")
	private int projectId;

	@NotBlank(message = "Reporter can't be null")
	@Size(min = 3, message = "Reporter must have at least 3 characters")
	private String reporter;

	@NotBlank(message = "Creator can't be null")
	@Size(min = 3, message = "Creator must have at least 3 characters")
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
	@Min(value = 1, message = "Time estimate can't be 0")
	private int timeEstimate;

	@NotNull(message = "Time spent can't be null")
	@Min(value = 1, message = "Time spent can't be 0")
	private int timeSpent;
	private IssueType issueType;
	private IssuePriority issuePriority;
	private IssueStatus issueStatus;

	public IssueDTO() {

	}

	public IssueDTO(int id, int parentId, String projectKey, int issueNumber, int projectId, String reporter,
			String creator, String summary, String description, Date created, Date updated, Date duedate,
			int timeEstimate, int timeSpent) {
		this.id = id;
		this.parentId = parentId;
		this.projectKey = projectKey;
		this.issueNumber = issueNumber;
		this.projectId = projectId;
		this.reporter = reporter;
		this.creator = creator;
		this.summary = summary;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.duedate = duedate;
		this.timeEstimate = timeEstimate;
		this.timeSpent = timeSpent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return "IssueDTO [id=" + id + ", parentId=" + parentId + ", projectKey=" + projectKey + ", issueNumber="
				+ issueNumber + ", projectId=" + projectId + ", reporter=" + reporter + ", creator=" + creator
				+ ", summary=" + summary + ", description=" + description + ", created=" + created + ", updated="
				+ updated + ", duedate=" + duedate + ", timeEstimate=" + timeEstimate + ", timeSpent=" + timeSpent
				+ ", issueType=" + issueType + ", issuePriority=" + issuePriority + ", issueStatus=" + issueStatus
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duedate == null) ? 0 : duedate.hashCode());
		result = prime * result + issueNumber;
		result = prime * result + ((issuePriority == null) ? 0 : issuePriority.hashCode());
		result = prime * result + ((issueStatus == null) ? 0 : issueStatus.hashCode());
		result = prime * result + ((issueType == null) ? 0 : issueType.hashCode());
		result = prime * result + parentId;
		result = prime * result + projectId;
		result = prime * result + ((projectKey == null) ? 0 : projectKey.hashCode());
		result = prime * result + ((reporter == null) ? 0 : reporter.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + timeEstimate;
		result = prime * result + timeSpent;
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueDTO other = (IssueDTO) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duedate == null) {
			if (other.duedate != null)
				return false;
		} else if (!duedate.equals(other.duedate))
			return false;
		if (issueNumber != other.issueNumber)
			return false;
		if (issuePriority == null) {
			if (other.issuePriority != null)
				return false;
		} else if (!issuePriority.equals(other.issuePriority))
			return false;
		if (issueStatus == null) {
			if (other.issueStatus != null)
				return false;
		} else if (!issueStatus.equals(other.issueStatus))
			return false;
		if (issueType == null) {
			if (other.issueType != null)
				return false;
		} else if (!issueType.equals(other.issueType))
			return false;
		if (parentId != other.parentId)
			return false;
		if (projectId != other.projectId)
			return false;
		if (projectKey == null) {
			if (other.projectKey != null)
				return false;
		} else if (!projectKey.equals(other.projectKey))
			return false;
		if (reporter == null) {
			if (other.reporter != null)
				return false;
		} else if (!reporter.equals(other.reporter))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (timeEstimate != other.timeEstimate)
			return false;
		if (timeSpent != other.timeSpent)
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		return true;
	}

}
