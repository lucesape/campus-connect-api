package com.campussocialmedia.campussocialmedia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.campussocialmedia.campussocialmedia.entity.UserDTO;

/*
class UserDetailsService is used by spring security to get the details of user
We have to create our own version of UserDetailsService to fetch the user details from our database
The job of MyUserDetailsService is to return a User object containing username and password of the 
user whose username is passed or throw UsernameNotFoundException. 
*/

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String inputUserName) throws UsernameNotFoundException {

		String userName;
		String password;

		try {
			UserDTO user = service.getUserByUserName(inputUserName);
			userName = user.getUserName();
			password = user.getPassword();
		} catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("User not found", e);
		}

		//Keeping the user authorities blank
		return new User(userName, password, new ArrayList<>());
	}
}
