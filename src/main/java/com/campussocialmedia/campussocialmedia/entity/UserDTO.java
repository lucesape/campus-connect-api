package com.campussocialmedia.campussocialmedia.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
//	private String userId;
	private String userName;
	private String email;
	private String password;
	private String year;
	private String department;
	private String firstName;
	private String lastName;
	private String phone;
	private List<String> personalChats;
	private List<String> groups;

	public UserDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<String> getPersonalChats() {
		return personalChats;
	}

	public void setPersonalChats(List<String> personalChats) {
		this.personalChats = personalChats;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
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

	public UserDTO(String userName, String email, String password, String year, String department, String firstName,
			String lastName, String phone, List<String> personalChats, List<String> groups) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.year = year;
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.personalChats = personalChats;
		this.groups = groups;
	}

	public UserDTO() {
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", email=" + email + ", password=" + password + ", year=" + year
				+ ", department=" + department + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", personalChats=" + personalChats + ", groups=" + groups + "]";
	}

	
	

	

}
