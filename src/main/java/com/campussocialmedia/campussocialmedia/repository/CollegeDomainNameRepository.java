package com.campussocialmedia.campussocialmedia.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.campussocialmedia.campussocialmedia.entity.CollegeDomainNames;

@Repository
public class CollegeDomainNameRepository {
	
	@Autowired
	private DynamoDBMapper mapper;
	
	public CollegeDomainNames addDomainName(CollegeDomainNames domainName) {
		mapper.save(domainName);
		return domainName;
	}

	public CollegeDomainNames findCollegeByDomainName(String domainName) {
		return mapper.load(CollegeDomainNames.class, domainName);
	}

	public String deleteDomainName(CollegeDomainNames domainName) {
		mapper.delete(domainName);
		return "DomainName Deleted";
	}


}
