package com.campussocialmedia.campussocialmedia.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/*
Defines input format for incoming Authentication requests
*/
public class AuthenticationRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String year;
	private String branch;
	private String collegeName;
	private MultipartFile image;

	// need default constructor for JSON Parsing
	public AuthenticationRequest() {
	}

	public AuthenticationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [branch=" + branch + ", collegeName=" + collegeName + ", email=" + email
				+ ", firstName=" + firstName + ", image=" + image + ", lastName=" + lastName + ", password=" + password
				+ ", userName=" + userName + ", year=" + year + "]";
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public AuthenticationRequest(String userName, String password, String email, String firstName, String lastName,
			String year, String branch, String collegeName, MultipartFile image) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		this.branch = branch;
		this.collegeName = collegeName;
		this.image = image;
	}

}
