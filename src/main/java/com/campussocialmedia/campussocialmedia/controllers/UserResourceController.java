package com.campussocialmedia.campussocialmedia.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campussocialmedia.campussocialmedia.entity.UserDTO;
import com.campussocialmedia.campussocialmedia.service.UserService;

@RestController
public class UserResourceController {
	@Autowired
	private UserService service;

	@PostMapping("/user")
	public UserDTO saveUser(@RequestBody UserDTO user) {
		return service.addUser(user);
	}

	@GetMapping("/user/{userName}")
	public ResponseEntity<?> findUser(@PathVariable String userName) {
		try {
			UserDTO user = service.getUserByUserName(userName);
//			return user;
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/userConvos/{userName}")
	public ResponseEntity<?> getAllConvoNames(@PathVariable String userName) {
		try {
			HashMap<String, List<String>> ConvosName = service.getAllConvoName(userName);
			return new ResponseEntity<>(ConvosName, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Conversations not found for the user", HttpStatus.NOT_FOUND);
		}
		
	}

//	@DeleteMapping("/deleteUser/{userId}/{userName}")
//	public String deletePerson(@PathVariable String userId, @PathVariable String userName) {
//		service.deleteUser(userId, userName);
//		return "User Deleted";
//	}

//	@PutMapping("/editUser")
//	public String updatePerson(@RequestBody User user) {
//		return repository.editPerson(user);
//	}

}
