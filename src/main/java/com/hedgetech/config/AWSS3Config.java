package com.hedgetech.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import service.aws.S3ClientService;

@Configuration
public class AWSS3Config {

	@Value("${cloud.aws.credentials.access-key}")
	private String accessKeyId;
	@Value("${cloud.aws.credentials.secret-key:}")
	private String secretAccessKey;
	@Value("${cloud.aws.region.static}")
	private String region;

	@Bean
	public AmazonS3 getAmazonS3Cient() {
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
		// Get AmazonS3 client and return the s3Client object.
		return AmazonS3ClientBuilder.standard().withRegion(Regions.fromName("us-east-1"))
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).build();
	}

//	@Bean
//	S3ClientService s3ClientService() {
//		return new S3ClientService();
//	}
}