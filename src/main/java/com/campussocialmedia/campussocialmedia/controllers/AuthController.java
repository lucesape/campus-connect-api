package com.campussocialmedia.campussocialmedia.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.core.userdetails.User;

import com.campussocialmedia.campussocialmedia.entity.AuthenticationRequest;
import com.campussocialmedia.campussocialmedia.entity.AuthenticationResponse;
import com.campussocialmedia.campussocialmedia.entity.UserDTO;
import com.campussocialmedia.campussocialmedia.entity.UserDetailsEntity;
import com.campussocialmedia.campussocialmedia.service.MyUserDetailsService;
import com.campussocialmedia.campussocialmedia.exception.ExceptionResponse;
// import com.campussocialmedia.campussocialmedia.service.MyUserDetailsService;
import com.campussocialmedia.campussocialmedia.service.UserService;
import com.campussocialmedia.campussocialmedia.util.JwtUtil;

/*
This class defines and implements the API endpoints for "/login" & "/signUp"
*/
@RestController
@CrossOrigin
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	// @Autowired
	// private MyUserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	/*
	 * The logic of signUp endpoint is to use AuthenticationManager to check if the
	 * username in the incoming AuthenticationRequest exists and act accordingly.
	 */
	@PostMapping(value = "/signUp")
	public ResponseEntity<?> signUp(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		// Try authenticating the given UserName and Password.
		// If no exception is thrown, then these credentials are already used.
		// If this UserName does not exists, then continue signUp. It will cause
		// AuthenticationException for unknown users.

		try {
			System.out.println(authenticationRequest);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (AuthenticationException e) {
			// This user does not exist
			UserDTO userDTO = new UserDTO(authenticationRequest.getUserName(), authenticationRequest.getEmail(),
					authenticationRequest.getPassword(), authenticationRequest.getFirstName(),
					authenticationRequest.getLastName(),
					authenticationRequest.getCollegeDetails()
					);
			System.out.println("New user created here:" + userDTO);
			userDTO = userService.addUser(userDTO);
			System.out.println("#####");
			// Why is JWT token returned after signup?
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(userDTO.getUserName(),
					userDTO.getPassword(), new ArrayList<>());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			
			UserDetailsEntity userDetailsEntity = new UserDetailsEntity(userDTO.getUserName(),
					userDTO.getEmail(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getIntro());

			return new ResponseEntity<>(new AuthenticationResponse(jwt, userDetailsEntity),
					org.springframework.http.HttpStatus.CREATED);
		}
		// If no exception is returned by the AuthenticationManager, then the user with
		// passed
		// userName already exists.
		return new ResponseEntity<>(new ExceptionResponse(new Date(), "User Already Exists", "/signUp"),
				org.springframework.http.HttpStatus.CONFLICT);
	}

	/*
	 * AuthenticationManager passes the userName from incoming AuthenticationRequest
	 * to MyUserDetailsService class to get the user object from the database as per
	 * the incoming userName If no user is found with the incoming
	 * AuthenticationRequest username, then AuthenticationException is thrown and
	 * appropriate ResponseEntity is returned
	 * 
	 * MyUserDetailsService returns a User object containing the username and
	 * password from the database. The password from the User object returned from
	 * MyUserDetailsService is matched with the password in the incoming
	 * AuthenticationRequest. If the password does not match, we throw a
	 * BadCredentialsException and return the appropriate ResponseEntity for the
	 * same
	 * 
	 * If the entire authentication by AuthenticationManager is successful, then we
	 * generate the JWT token as per the user details and return the generated JWT
	 * token and user as repsonse.
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		System.out.println(authenticationRequest);
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
				authenticationRequest.getPassword()));

		try {
			UserDetailsEntity user = userService.getUserBasicDetailsByUserName(authenticationRequest.getUserName());
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(authenticationRequest.getUserName(),
					authenticationRequest.getPassword(), new ArrayList<>());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new AuthenticationResponse(jwt, user));
			
		} catch (UsernameNotFoundException e) {
			return new ResponseEntity<>("No such user", org.springframework.http.HttpStatus.NOT_FOUND);
		}

	}

}
