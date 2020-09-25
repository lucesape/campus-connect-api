package com.campussocialmedia.campussocialmedia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campussocialmedia.campussocialmedia.entity.User;
import com.campussocialmedia.campussocialmedia.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User addUser(User user) {
		List<Long> emptyList = new ArrayList<Long>();
		user.setPersonalChats(emptyList);
		user.setGroups(emptyList);

		return repository.addUser(user);
	}

	public void deleteUser(String userId, String userName) {
		User user = getUserByIdAndUserName(userId, userName);
		repository.deleteUser(user);
	}

	public User getUserByIdAndUserName(String userId, String userName) {
		return repository.findUserByIdAndUserName(Long.parseLong(userId), userName);
	}

	public HashMap<String, List<Long>> getAllConvoName(String userId, String userName) {
		User user = getUserByIdAndUserName(userId, userName);
		HashMap<String, List<Long>> convoNames = new HashMap<String, List<Long>>();
		convoNames.put("Personal", user.getPersonalChats());
		convoNames.put("Group", user.getGroups());
		return convoNames;
	}

}
