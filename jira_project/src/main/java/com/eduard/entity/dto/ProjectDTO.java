package com.eduard.entity.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.eduard.entity.Issue;
import com.eduard.entity.ProjectRole;
import com.eduard.entity.ProjectVersion;

public class ProjectDTO {

	private String description;
	private String leader;
	private String projectKey;
	private String projectName;
	private String projectType;
	private String url;
	private Set<ProjectVersion> versions = new HashSet<>();
	private List<Issue> issues = new ArrayList<>();
	private List<ProjectRole> roles = new ArrayList<>();

	public ProjectDTO() {

	}

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
		return "ProjectRequestDTO [description=" + description + ", leader=" + leader + ", projectKey=" + projectKey
				+ ", projectName=" + projectName + ", projectType=" + projectType + ", url=" + url + ", versions="
				+ versions + ", issues=" + issues + ", roles=" + roles + "]";
	}

}
