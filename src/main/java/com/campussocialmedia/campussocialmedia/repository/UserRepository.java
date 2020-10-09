package com.campussocialmedia.campussocialmedia.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.campussocialmedia.campussocialmedia.entity.UserDBEntity;

@Repository
public class UserRepository {

	@Autowired
	private DynamoDBMapper mapper;

	public UserDBEntity addUser(UserDBEntity user) {
		mapper.save(user);
		return user;
	}

	public UserDBEntity findUserByIdAndUserName(Long userId, String userName) {
		return mapper.load(UserDBEntity.class, userName);
	}

	public UserDBEntity findUserByUserName(String userName) {
		return mapper.load(UserDBEntity.class, userName);
	}

	public String deleteUser(UserDBEntity user) {
		mapper.delete(user);
		return "User Deleted";
	}

	public String updateUser(UserDBEntity user) {
		mapper.save(user, buildExpression(user));
		System.out.print("FOLLOWERS ADDED");
		return "User Updated";
	}

	private DynamoDBSaveExpression buildExpression(UserDBEntity user) {
		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
		expectedMap.put("userName", new ExpectedAttributeValue(new AttributeValue().withS(user.getUserName())));
		dynamoDBSaveExpression.setExpected(expectedMap);
		return dynamoDBSaveExpression;
	}
}
