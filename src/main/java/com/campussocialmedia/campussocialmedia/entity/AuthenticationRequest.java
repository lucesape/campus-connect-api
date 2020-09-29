package com.campussocialmedia.campussocialmedia.entity;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;

	public String getUsername() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// need default constructor for JSON Parsing
	public AuthenticationRequest() {

	}

	public AuthenticationRequest(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [userName=" + userName + ", password=" + password + "]";
	}
}
