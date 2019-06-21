package com.eduard.entity.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.eduard.entity.Issue;
import com.eduard.entity.ProjectRole;
import com.eduard.entity.ProjectVersion;

public class ProjectDTO {

	@NotBlank(message = "Description can't be null")
	@Size(min = 20, message = "Description must have at least 20 characters")
	private String description;

	@NotBlank(message = "Leader can't be null")
	@Size(min = 3, message = "Leader must have at least 3 characters")
	private String leader;

	@NotBlank(message = "Project key can't be null")
	@Size(min = 2, message = "Project key must have at least 2 characters")
	private String projectKey;

	@NotBlank(message = "Project name can't be null")
	@Size(min = 5, message = "Project key name have at least 5 characters")
	private String projectName;

	@NotBlank(message = "Project type can't be null")
	@Size(min = 5, message = "Project type name have at least 5 characters")
	private String projectType;

	@NotBlank(message = "Url can't be null")
	@URL(message = "Enter a valid url")
	private String url;
	private Set<ProjectVersion> versions = new HashSet<>();
	private List<Issue> issues = new ArrayList<>();
	private List<ProjectRole> roles = new ArrayList<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<ProjectVersion> getVersions() {
		return versions;
	}

	public void setVersions(Set<ProjectVersion> versions) {
		this.versions = versions;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public List<ProjectRole> getRoles() {
		return roles;
	}

	public void setRoles(List<ProjectRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "ProjectDTO [description=" + description + ", leader=" + leader + ", projectKey=" + projectKey
				+ ", projectName=" + projectName + ", projectType=" + projectType + ", url=" + url + ", versions="
				+ versions + ", issues=" + issues + ", roles=" + roles + "]";
	}

}
