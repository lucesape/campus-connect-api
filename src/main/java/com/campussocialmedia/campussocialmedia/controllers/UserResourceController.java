package com.campussocialmedia.campussocialmedia.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campussocialmedia.campussocialmedia.entity.User;
import com.campussocialmedia.campussocialmedia.service.UserService;

@RestController
public class UserResourceController {
	@Autowired
	private UserService service;

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@GetMapping("/user/{userId}/{userName}")
	public User findUser(@PathVariable String userId, @PathVariable String userName) {
		User userByIdAndUserName = service.getUserByIdAndUserName(userId, userName);
		System.out.println(userByIdAndUserName);
		return userByIdAndUserName;
	}

	@GetMapping("/userConvos/{userId}/{userName}")
	public HashMap<String, List<Long>> getAllConvoNames(@PathVariable String userId, @PathVariable String userName) {
		return service.getAllConvoName(userId, userName);
	}

	@DeleteMapping("/deleteUser/{userId}/{userName}")
	public String deletePerson(@PathVariable String userId, @PathVariable String userName) {
		service.deleteUser(userId, userName);
		return "User Deleted";
	}

//	@PutMapping("/editUser")
//	public String updatePerson(@RequestBody User user) {
//		return repository.editPerson(user);
//	}

}
