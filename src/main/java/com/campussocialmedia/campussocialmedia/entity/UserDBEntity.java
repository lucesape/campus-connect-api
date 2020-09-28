package com.campussocialmedia.campussocialmedia.entity;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "UserTable")
public class UserDBEntity {
	private String userId;
	private String userName;
	private String email;
	private String password;

	private String firstName;
	private String lastName;
	private String phone;
	private List<String> personalChats;
	private List<String> groups;

	@DynamoDBAttribute
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@DynamoDBHashKey(attributeName = "userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@DynamoDBAttribute
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@DynamoDBAttribute
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@DynamoDBAttribute
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBAttribute
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@DynamoDBAttribute
	public List<String> getPersonalChats() {
		return personalChats;
	}

	public void setPersonalChats(List<String> personalChats) {
		this.personalChats = personalChats;
	}

	@DynamoDBAttribute
	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public UserDBEntity(String userId, String userName, String email, String password, String firstName, String lastName,
			String phone, List<String> personalChats, List<String> groups) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.personalChats = personalChats;
		this.groups = groups;
	}

	public UserDBEntity() {
		super();
	}

	public UserDBEntity(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", personalChats="
				+ personalChats + ", groups=" + groups + "]";
	}

}
