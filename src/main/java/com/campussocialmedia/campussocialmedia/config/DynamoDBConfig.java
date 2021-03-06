package com.campussocialmedia.campussocialmedia.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;

import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfig {

	// @Value("${amazon.access.key}")
	// private String awsAccessKey;

	// @Value("${amazon.access.secret-key}")
	// private String awsSecretKey;

	// @Value("${amazon.end-point.url}")
	// private String awsDynamoDBEndPoint;

	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	@Value("${amazonProperties.accessKey}")
	private String accessKey;
	@Value("${amazonProperties.secretKey}")
	private String secretKey;
	@Value("${amazonProperties.sessionToken}")
	private String sessionToken;

	@Bean
	public AWSCredentials amazonAWSCredentials() {
		return new BasicSessionCredentials(this.accessKey, this.secretKey, this.sessionToken);
	}

	public AWSCredentialsProvider amazonAWSCredentialsProvider() {
		return new AWSStaticCredentialsProvider(amazonAWSCredentials());
	}

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1)
				.withCredentials(amazonAWSCredentialsProvider()).build();
	}

	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDB());
	}
}
