package com.campussocialmedia.campussocialmedia.entity;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "User")
public class User {
	private Long userId;
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	private List<Long> personalChats;
	private List<Long> groups;

	@DynamoDBHashKey(attributeName = "userId")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@DynamoDBRangeKey(attributeName = "userName")
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
	public List<Long> getPersonalChats() {
		return personalChats;
	}

	public void setPersonalChats(List<Long> personalChats) {
		this.personalChats = personalChats;
	}

	@DynamoDBAttribute
	public List<Long> getGroups() {
		return groups;
	}

	public void setGroups(List<Long> groups) {
		this.groups = groups;
	}

	public User() {
	}

	public User(Long userId, String userName, String email, String firstName, String lastName, String phone,
			List<Long> personalChats, List<Long> groups) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.personalChats = personalChats;
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", personalChats=" + personalChats + ", groups="
				+ groups + "]";
	}

}
