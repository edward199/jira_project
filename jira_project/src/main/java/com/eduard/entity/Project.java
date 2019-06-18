package com.eduard.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "leader")
	private String leader;

	@Column(name = "project_key")
	private String projectKey;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "project_type")
	private String projectType;

	@Column(name = "url")
	private String url;

	@OneToMany
	@JoinColumn(name = "project_id")
	private Set<ProjectVersion> versions = new HashSet<>();

	@OneToMany
	@JoinColumn(name = "project_id")
	private List<Issue> issues = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "project_project_roles", joinColumns = {
			@JoinColumn(name = "project_id") }, inverseJoinColumns = { @JoinColumn(name = "project_role_id") })
	private List<ProjectRole> roles = new ArrayList<>();

	public Project() {

	}

	public Project(String description, String leader, String projectKey, String projectName, String projectType,
			String url) {
		super();
		this.description = description;
		this.leader = leader;
		this.projectKey = projectKey;
		this.projectName = projectName;
		this.projectType = projectType;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
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
		return "Project [id=" + id + ", projectName=" + projectName + ", url=" + url + ", leader=" + leader
				+ ", description=" + description + ", projectKey=" + projectKey + ", projectType=" + projectType
				+ ", versions=" + versions + ", issues=" + issues + ", roles=" + roles + "]";
	}

}
