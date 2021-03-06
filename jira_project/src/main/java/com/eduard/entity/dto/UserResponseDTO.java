package com.eduard.entity.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.eduard.entity.ProjectRole;

public class UserResponseDTO {

	private String userName;
	private int active;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private String firstName;
	private String lastName;
	private String displayName;
	private String emailAddress;
	private List<ProjectRole> roles = new ArrayList<>();

	public UserResponseDTO() {

	}

	public UserResponseDTO(String userName, int active, Timestamp createdDate, Timestamp updatedDate, String firstName,
			String lastName, String displayName, String emailAddress, List<ProjectRole> roles) {
		super();
		this.userName = userName;
		this.active = active;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.emailAddress = emailAddress;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<ProjectRole> getRoles() {
		return roles;
	}

	public void setRoles(List<ProjectRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserResponseDTO [userName=" + userName + ", active=" + active + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", displayName=" + displayName + ", emailAddress=" + emailAddress + ", roles=" + roles + "]";
	}

}
