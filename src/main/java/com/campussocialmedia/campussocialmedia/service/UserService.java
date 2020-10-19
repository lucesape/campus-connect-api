package com.campussocialmedia.campussocialmedia.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.SignatureException;

import com.campussocialmedia.campussocialmedia.entity.UserAbout;
import com.campussocialmedia.campussocialmedia.entity.UserDBEntity;
import com.campussocialmedia.campussocialmedia.entity.UserDTO;
import com.campussocialmedia.campussocialmedia.entity.UserDetailsEntity;
import com.campussocialmedia.campussocialmedia.entity.UserFollowerFollowing;
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
	private UserDBEntity convertToEntity(UserAbout user) {
		return modelMapper.map(user, UserDBEntity.class);
	}

	private UserDTO convertToDTO(UserDBEntity user) {
		return modelMapper.map(user, UserDTO.class);
	}
	private UserDetailsEntity convertToDetailsEntity(UserDBEntity user) {
		return modelMapper.map(user, UserDetailsEntity.class);
	}
	private UserAbout convertToAbout(UserDBEntity user)
	{
		return modelMapper.map(user, UserAbout.class);
	} 
	private UserFollowerFollowing convertToFollowerFollowing(UserDBEntity user)
	{
		return modelMapper.map(user, UserFollowerFollowing.class);
	} 

	public UserDTO addUser(UserDTO user) {
		List<Long> emptyList = new ArrayList<Long>();
		user.setPersonalChats(emptyList);
		user.setGroups(emptyList);

		UserDBEntity userEntity = repository.addUser(convertToEntity(user));
		return convertToDTO(userEntity);
	}

	public void addFollowerFollowing(String follower, String following, String jwtUserName) {

		if (!jwtUserName.equals(follower))
			throw new SignatureException("Token does not match with userName");
		UserDBEntity followerEntity = repository.findUserByUserName(follower);
		if (followerEntity == null)
			throw new UsernameNotFoundException("User " + follower + " Not Found");
		UserDBEntity followingEntity = repository.findUserByUserName(following);
		if (followingEntity == null)
			throw new UsernameNotFoundException("User " + following + " Not Found");

		List<String> followingList = followingEntity.getFollowing();
		// If user already in following list, No need to add the user in the list
		if (followingList.contains(follower))
			return;
		followingList.add(follower);
		followingEntity.setFollowing(followingList);
		repository.updateUser(followingEntity);
		// if not present then only add else throw exception
		List<String> followersList = followerEntity.getFollowers();
		followersList.add(following);
		followerEntity.setFollowers(followersList);
		repository.updateUser(followerEntity);
		// Nothing to return

	}

	// public UserDTO getUserByIdAndUserName(String userId, String userName) {
	// UserDBEntity userDBEntity =
	// repository.findUserByIdAndUserName(Long.parseLong(userId), userName);
	// UserDTO userDTO = convertToDTO(userDBEntity);
	// return userDTO;
	// }

	public UserDTO getUserByUserName(String userName) {
		UserDBEntity userDBEntity = repository.findUserByUserName(userName);
		UserDTO userDTO = convertToDTO(userDBEntity);
		return userDTO;
	}
	
	public UserDetailsEntity getUserBasicDetailsByUserName(String userName) {
		UserDBEntity userDBEntity = repository.findUserByUserName(userName);
		UserDetailsEntity userDetailsEntity = convertToDetailsEntity(userDBEntity);
		return userDetailsEntity;
	}
	
	public UserAbout getUserAboutByUserName(String userName) {
		UserDBEntity userDBEntity = repository.findUserByUserName(userName);
		UserAbout userAbout = convertToAbout(userDBEntity);
		return userAbout;
	}
	
	public UserAbout updateUserAboutDetails(UserAbout user)
	{
		UserDBEntity updatedUser  = convertToEntity(user);
		updatedUser = repository.updateUserAboutDetails(updatedUser);
		UserAbout userAbout = convertToAbout(updatedUser);
		return userAbout ;
	}
	public UserFollowerFollowing getUserFollowerFollowingByUserName(String userName) {
		UserDBEntity userDBEntity = repository.findUserByUserName(userName);
		UserFollowerFollowing userAbout = convertToFollowerFollowing(userDBEntity);
		return userAbout;
	}

	
	public HashMap<String, List<Long>> getAllConvoName(String userName) {
		UserDTO user = getUserByUserName(userName);
		HashMap<String, List<Long>> convoNames = new HashMap<String, List<Long>>();
		convoNames.put("Personal", user.getPersonalChats());
		convoNames.put("Group", user.getGroups());
		return convoNames;
	}
	

}
