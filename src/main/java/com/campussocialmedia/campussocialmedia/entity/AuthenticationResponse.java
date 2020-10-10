package com.campussocialmedia.campussocialmedia.entity;

import java.io.Serializable;

/*
Specifies the Authentication response object.
Currently we need only one field in the Authentication Response object which is the JWT token.
*/
public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String jwt;
	private UserDTO user;

	
	public AuthenticationResponse(String jwt, UserDTO user) {
		super();
		this.jwt = jwt;
		this.user = user;
	}

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + ", user=" + user + "]";
	} 
	
}
