package com.campussocialmedia.campussocialmedia.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.internal.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.amazonaws.services.ecr.model.Repository;
import com.amazonaws.services.identitymanagement.model.UserDetail;
import com.campussocialmedia.campussocialmedia.CampusSocialMediaApplication;
import com.campussocialmedia.campussocialmedia.entity.College;
import com.campussocialmedia.campussocialmedia.entity.PersonalDetails;
import com.campussocialmedia.campussocialmedia.entity.UserAbout;
import com.campussocialmedia.campussocialmedia.entity.UserDBEntity;
import com.campussocialmedia.campussocialmedia.entity.UserDTO;
import com.campussocialmedia.campussocialmedia.entity.UserDetailsEntity;
import com.campussocialmedia.campussocialmedia.entity.UserFollowerFollowing;
import com.campussocialmedia.campussocialmedia.repository.UserRepository;

@SpringBootTest(classes = CampusSocialMediaApplication.class)
class UserServiceTest {
	@Autowired
	private UserService userservice;
	
	@MockBean
	private UserRepository repository;
	
	
	@Test 
	public void getUserTest(){

	}
	
	@Test
	public void findUserByUserNameTest() {
		UserDBEntity user = new UserDBEntity();
		user.setUserName("ABC");
		user.setPassword("password");
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("ABC");
		userDTO.setPassword("password");
		Mockito.when(repository.findUserByUserName("ABC")).thenReturn(user);
		assertTrue(new ReflectionEquals(userDTO).matches(userservice.getUserByUserName("ABC")));
	}
	
	@Test
	public void addUserTest() {
		UserDBEntity user = new UserDBEntity();
		user.setUserName("A");
		user.setPassword("password");
		user.setEmail("email");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		College college = new College("First", "DEP", "Btech");
		user.setCollegeDetails(college);
		List<Long> emptyList = new ArrayList<Long>();
		user.setPersonalChats(emptyList);
		user.setGroups(emptyList);
		PersonalDetails details = new PersonalDetails("-", new ArrayList<String>(), new ArrayList<String>());
		user.setPersonalDetails(details);
		user.setFollowers(new ArrayList<String>());
		user.setFollowing(new ArrayList<String>());
		user.setBio("-");
		user.setIntro("-");
		user.setPosts(new ArrayList<>());
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("A");
		userDTO.setPassword("password");
		userDTO.setEmail("email");
		userDTO.setFirstName("firstName");
		userDTO.setLastName("lastName");
		userDTO.setCollegeDetails(college);
		
		UserDTO expectedDTO = new UserDTO();
		expectedDTO.setUserName("A");
		expectedDTO.setPassword("password");
		expectedDTO.setEmail("email");
		expectedDTO.setFirstName("firstName");
		expectedDTO.setLastName("lastName");
		expectedDTO.setCollegeDetails(college);
		expectedDTO.setPersonalChats(emptyList);
		expectedDTO.setGroups(emptyList);
		expectedDTO.setPersonalDetails(details);
		expectedDTO.setFollowers(new ArrayList<String>());
		expectedDTO.setFollowing(new ArrayList<String>());
		expectedDTO.setBio("-");
		expectedDTO.setIntro("-");
		expectedDTO.setPosts(new ArrayList<>());
		
		Mockito.when(repository.addUser(user)).thenReturn(user);
		assertTrue(new org.mockito.internal.matchers.apachecommons.ReflectionEquals(expectedDTO).matches(userservice));
	}
	
	@Test
	public void getUserAboutByUserNameTest()
	{
		College college = new College("First", "DEP", "Btech");
		UserAbout userAbout = new UserAbout("A", "email", "password", "firstName","lastName",
				college);
		
		UserDBEntity user = new UserDBEntity();
		user.setUserName("A");
		user.setPassword("password");
		user.setEmail("email");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setCollegeDetails(college);
		List<Long> emptyList = new ArrayList<Long>();
		user.setPersonalChats(emptyList);
		user.setGroups(emptyList);
		PersonalDetails details = new PersonalDetails("-", new ArrayList<String>(), new ArrayList<String>());
		user.setPersonalDetails(details);
		user.setFollowers(new ArrayList<String>());
		user.setFollowing(new ArrayList<String>());
		user.setBio("-");
		user.setIntro("-");
		user.setPosts(new ArrayList<>());
		
		userAbout.setPersonalDetails(details);
		userAbout.setBio("-");
		userAbout.setIntro("-");
		Mockito.when(repository.findUserByUserName("A")).thenReturn(user);
//		assertTrue(new ReflectionEquals(userAbout).matches(userservice.getUserAboutByUserName("A")));
		assertEquals(userAbout, userservice.getUserAboutByUserName("A"));
		
	}
	
	@Test
	public void getFollowerFollowingByUserNameTest()
	{
		College college = new College("First", "DEP", "Btech");
		PersonalDetails details = new PersonalDetails("-", new ArrayList<String>(), new ArrayList<String>());
//		UserAbout userAbout = new UserAbout("A", "email", "password", "firstName","lastName",
//				college);
//		userAbout.setPersonalDetails(details);
//		userAbout.setBio("-");
//		userAbout.setIntro("-");
		UserFollowerFollowing userFollowerFollowing = new UserFollowerFollowing();
		userFollowerFollowing.setUserName("A");
		userFollowerFollowing.setFollowers(new ArrayList<String>());
		userFollowerFollowing.setFollowing(new ArrayList<String>());
		
		UserDBEntity user = new UserDBEntity();
		user.setUserName("A");
		user.setPassword("password");
		user.setEmail("email");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setCollegeDetails(college);
		List<Long> emptyList = new ArrayList<Long>();
		user.setPersonalChats(emptyList);
		user.setGroups(emptyList);
		user.setPersonalDetails(details);
		user.setFollowers(new ArrayList<String>());
		user.setFollowing(new ArrayList<String>());
		user.setBio("-");
		user.setIntro("-");
		user.setPosts(new ArrayList<>());
		
		Mockito.when(repository.findUserByUserName("A")).thenReturn(user);
		assertEquals(userFollowerFollowing, userservice.getUserFollowerFollowingByUserName("A"));
		
	}

}
