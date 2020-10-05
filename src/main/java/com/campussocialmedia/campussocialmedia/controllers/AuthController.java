package com.campussocialmedia.campussocialmedia.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.core.userdetails.User;

import com.campussocialmedia.campussocialmedia.entity.AuthenticationRequest;
import com.campussocialmedia.campussocialmedia.entity.AuthenticationResponse;
import com.campussocialmedia.campussocialmedia.entity.UserDTO;
import com.campussocialmedia.campussocialmedia.service.MyUserDetailsService;
import com.campussocialmedia.campussocialmedia.service.UserService;
import com.campussocialmedia.campussocialmedia.util.JwtUtil;

@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

	@PostMapping(value = "/signUp")
	public ResponseEntity<?> signUp(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			System.out.println(authenticationRequest);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (AuthenticationException e) {
			// This user does not exist
			UserDTO user = new UserDTO(authenticationRequest.getUserName(), authenticationRequest.getEmail(), authenticationRequest.getPassword(),
					authenticationRequest.getYear(), authenticationRequest.getDepartment(), authenticationRequest.getFirstName(), authenticationRequest.getLastName(), authenticationRequest.getPhone(),
					new ArrayList<String>(), new ArrayList<String>());
//			String userId, String userName, String email, String password, String year, String department,
//			String firstName, String lastName, String phone, List<String> personalChats, List<String> groups
			System.out.println("New user created here:" + user);
			user = userService.addUser(user);
			System.out.println("User Added to DB");
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),
					user.getPassword(), new ArrayList<>());
			final String jwt = jwtTokenUtil.generateToken(userDetails);

			return new ResponseEntity<>(new AuthenticationResponse(jwt), org.springframework.http.HttpStatus.CREATED);
		} catch (Exception e) {
			throw new Exception("Some error occurred", e);
		}

//		throw new Exception("User Already exists!");
		return new ResponseEntity<>("user already exists", org.springframework.http.HttpStatus.CONFLICT );
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			System.out.println(authenticationRequest);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>("Incorrect Password", org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY);
//			throw new Exception("Incorrect password", e);
		} catch (AuthenticationException e) {
			return new ResponseEntity<>("No such user", org.springframework.http.HttpStatus.NOT_FOUND);
//			throw new Exception("No such user", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
