package com.campussocialmedia.campussocialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campussocialmedia.campussocialmedia.entity.CollegeDomainNames;
import com.campussocialmedia.campussocialmedia.entity.UserDBEntity;
import com.campussocialmedia.campussocialmedia.entity.UserDTO;
import com.campussocialmedia.campussocialmedia.repository.CollegeDomainNameRepository;

@Service
public class CollegeDomainNameService {
	
	@Autowired
	private CollegeDomainNameRepository repository;
	
	public CollegeDomainNames getCollegeByDomainName(String domainName) {
		//CollegeDomainNames domainNameObj = repository.findCollegeByDomainName(domainName);
		
		return repository.findCollegeByDomainName(domainName);
	}
	
	public CollegeDomainNames addDomainName(CollegeDomainNames domainName) {
		
		return repository.addDomainName(domainName);
		//return domainName;
	}
	
	public String deleteDomainName(CollegeDomainNames domainName) {
		
		return repository.deleteDomainName(domainName);
	}

}
