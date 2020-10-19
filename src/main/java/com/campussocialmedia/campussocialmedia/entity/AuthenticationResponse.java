package com.campussocialmedia.campussocialmedia.entity;

import java.io.Serializable;

/*
Specifies the Authentication response object.
Currently we need only one field in the Authentication Response object which is the JWT token.
*/
public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String jwt;
	private UserDetailsEntity user;

	
	public AuthenticationResponse(String jwt, UserDetailsEntity user) {
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

	public UserDetailsEntity getUser() {
		return user;
	}

	public void setUser(UserDetailsEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + ", user=" + user + "]";
	} 
	
}
