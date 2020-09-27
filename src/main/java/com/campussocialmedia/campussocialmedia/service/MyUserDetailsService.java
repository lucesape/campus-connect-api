package com.campussocialmedia.campussocialmedia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.campussocialmedia.campussocialmedia.entity.UserDTO;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

		String userName;
		String password;

		try {
			UserDTO user = service.getUserByUserName(s);
			userName = user.getUserName();
			password = user.getPassword();
		} catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("User not found", e);
		}

		return new User(userName, password, new ArrayList<>());
	}
}
