package com.campussocialmedia.campussocialmedia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campussocialmedia.campussocialmedia.entity.UserDBEntity;
import com.campussocialmedia.campussocialmedia.entity.UserDTO;
import com.campussocialmedia.campussocialmedia.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	private UserDBEntity convertToEntity(UserDTO user) {
		return modelMapper.map(user, UserDBEntity.class);
	}

	private UserDTO convertToDTO(UserDBEntity user) {
		return modelMapper.map(user, UserDTO.class);
	}

	public UserDTO addUser(UserDTO user) {
		List<Long> emptyList = new ArrayList<Long>();
		user.setPersonalChats(emptyList);
		user.setGroups(emptyList);

		UserDBEntity userEntity = repository.addUser(convertToEntity(user));
		return convertToDTO(userEntity);
	}

//	public UserDTO getUserByIdAndUserName(String userId, String userName) {
//		UserDBEntity userDBEntity = repository.findUserByIdAndUserName(Long.parseLong(userId), userName);
//		UserDTO userDTO = convertToDTO(userDBEntity);
//		return userDTO;
//	}

	public UserDTO getUserByUserName(String userName) {
		UserDBEntity userDBEntity = repository.findUserByUserName(userName);
		UserDTO userDTO = convertToDTO(userDBEntity);
		return userDTO;
	}

	public HashMap<String, List<Long>> getAllConvoName(String userName) {
		UserDTO user = getUserByUserName(userName);
		HashMap<String, List<Long>> convoNames = new HashMap<String, List<Long>>();
		convoNames.put("Personal", user.getPersonalChats());
		convoNames.put("Group", user.getGroups());
		return convoNames;
	}

}
