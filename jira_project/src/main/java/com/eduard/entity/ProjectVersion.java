package com.eduard.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_version")
public class ProjectVersion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "project_id")
	private int projectId;

	@Column(name = "version_name")
	private String versionName;

	@Column(name = "description")
	private String description;

	@Column(name = "released")
	private String released;

	@Column(name = "archived")
	private String archived;

	@Column(name = "url")
	private String url;

	@Column(name = "start_date")
	private Timestamp startDate;

	@Column(name = "release_date")
	private Timestamp releaseDate;

	public String getArchived() {
		return archived;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public int getProjectId() {
		return projectId;
	}

	public String getReleased() {
		return released;
	}

	public Timestamp getReleaseDate() {
		return releaseDate;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public String getUrl() {
		return url;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setArchived(String archived) {
		this.archived = archived;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((versionName == null) ? 0 : versionName.hashCode());
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
		ProjectVersion other = (ProjectVersion) obj;
		if (versionName == null) {
			if (other.versionName != null)
				return false;
		} else if (!versionName.equals(other.versionName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProjectVersion [id=" + id + ", projectId=" + projectId + ", versionName=" + versionName
				+ ", description=" + description + ", released=" + released + ", archived=" + archived + ", url=" + url
				+ ", startDate=" + startDate + ", releaseDate=" + releaseDate + "]";
	}

}
