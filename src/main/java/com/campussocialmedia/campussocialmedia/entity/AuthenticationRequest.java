package com.campussocialmedia.campussocialmedia.entity;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String year;
	private String department;
	private String phone;
	// need default constructor for JSON Parsing
	public AuthenticationRequest() {
	}
	
	public AuthenticationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	
	public AuthenticationRequest(String userName, String password, String email, String firstName, String lastName,
			String year, String department, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.year = year;
		this.department = department;
		this.phone = phone;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [userName=" + userName + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", year=" + year + ", department="
				+ department + ", phone=" + phone + "]";
	}

	

}
