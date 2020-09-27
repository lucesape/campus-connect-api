package com.campussocialmedia.campussocialmedia.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public UserDTO findUser(@PathVariable String userName) {
		UserDTO user = service.getUserByUserName(userName);
		return user;
	}

	@GetMapping("/userConvos/{userId}/{userName}")
	public HashMap<String, List<Long>> getAllConvoNames(@PathVariable String userId, @PathVariable String userName) {
		return service.getAllConvoName(userName);
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
