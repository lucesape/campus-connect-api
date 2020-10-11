package com.campussocialmedia.campussocialmedia.entity;

import java.util.List;

public class UserAbout {
	private String userName;
	private String email;
	private String year;
	private String department;
	private String firstName;
	private String lastName;
	private String phone;
	public UserAbout(String userName, String email, String year, String department, String firstName, String lastName,
			String phone) {
		super();
		this.userName = userName;
		this.email = email;
		this.year = year;
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
	public UserAbout() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserAbout [userName=" + userName + ", email=" + email + ", year=" + year + ", department=" + department
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + "]";
	}
	
}
