package com.campussocialmedia.campussocialmedia.controllers;

import java.util.ArrayList;

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

/*
This class defines and implements the API endpoints for "/login" & "/signup"
*/
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


	/*
	The logic of signUp endpoint is to use AuthenticationManager to check if the username in the 
	incoming AuthenticationRequest exists and act accordingly.
	*/
	@PostMapping(value = "/signUp")
	public ResponseEntity<?> signUp(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			System.out.println(authenticationRequest);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (AuthenticationException e) { //The user with incoming username does not exist
			//create the user with passed username
			UserDTO user = new UserDTO(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			
			//Add the user to database
			user = userService.addUser(user);

			//Why is JWT token returned after signup?
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),
					user.getPassword(), new ArrayList<>());
			final String jwt = jwtTokenUtil.generateToken(userDetails);

			return new ResponseEntity<>(new AuthenticationResponse(jwt), org.springframework.http.HttpStatus.CREATED);
		} catch (Exception e) {
			throw new Exception("Some error occurred", e);
		}

		//If no exception is returned by the AuthenticationManager, then the user with passed
		//userName already exists.
		return new ResponseEntity<>("user already exists", org.springframework.http.HttpStatus.CONFLICT );
	}

	/*
	AuthenticationManager passes the userName from incoming AuthenticationRequest to 
	MyUserDetailsService class to get the user object from the database as per the incoming userName
	If no user is found with the incoming AuthenticationRequest username, then AuthenticationException
	is thrown and appropriate ResponseEntity is returned

	MyUserDetailsService returns a User object containing the username and password from the database.
	The password from the User object returned from MyUserDetailsService is matched with the password
	in the incoming AuthenticationRequest.
	If the password does not match, we throw a BadCredentialsException and return the appropriate 
	ResponseEntity for the same

	If the entire authentication by AuthenticationManager is successfull, then we generate the
	JWT token as per the user details and return the generated JWT token as reponse.
	*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			System.out.println(authenticationRequest);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>("Incorrect Password", org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (AuthenticationException e) {
			return new ResponseEntity<>("No such user", org.springframework.http.HttpStatus.NOT_FOUND);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
