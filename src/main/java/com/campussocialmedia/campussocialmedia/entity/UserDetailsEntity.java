package com.campussocialmedia.campussocialmedia.entity;

import java.util.HashMap;
import java.util.List;

public class UserDetailsEntity {

	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private String intro;
	private String profilePhotoURL;

	public UserDetailsEntity() {
		super();
	}

	public UserDetailsEntity(String userName, String email, String firstName, String lastName, String intro,
			String profilePhotoURL) {
		super();
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.intro = intro;
		this.profilePhotoURL = profilePhotoURL;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getProfilePhotoURL() {
		return profilePhotoURL;
	}

	public void setProfilePhotoURL(String profilePhotoURL) {
		this.profilePhotoURL = profilePhotoURL;
	}

	@Override
	public String toString() {
		return "UserDetailsEntity [email=" + email + ", firstName=" + firstName + ", intro=" + intro + ", lastName="
				+ lastName + ", profilePhotoURL=" + profilePhotoURL + ", userName=" + userName + "]";
	}

}
