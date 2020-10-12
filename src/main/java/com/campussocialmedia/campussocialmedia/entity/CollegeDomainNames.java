
package com.campussocialmedia.campussocialmedia.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "CollegeDomainName")
public class CollegeDomainNames {
	
	private String collegeName;
	private String domainName;
	
	
	public CollegeDomainNames() {
		super(); 
	}
	public CollegeDomainNames(String collegeName, String domainName) {
		super();
		this.collegeName = collegeName;
		this.domainName = domainName;
	}
	
	@DynamoDBAttribute
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	@DynamoDBHashKey(attributeName = "domainName")
	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	@Override
	public String toString() {
		return "CollegeDomainNames [collegeName=" + collegeName + ", domainName=" + domainName + "]";
	}
	
	

}
