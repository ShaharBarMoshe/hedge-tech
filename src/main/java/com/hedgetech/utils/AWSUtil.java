package com.hedgetech.utils;

import java.util.Properties;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.google.gson.JsonElement;
import com.hedgetech.service.aws.S3ClientService;


/**
 * Utility for using AWS bucket
 * @author shaharb
 *
 */
public class AWSUtil {
	
	private AWSUtil() {}
	// for simplicity the vars was not stored as env vars.
	// spring bus config can be better approach
	private static final String CONFIG_FILE_NAME = "config.json";
	private static final String BUCKET_CONFIG_NAME = "ht-prog-test";
	private static final String BUCKET_SECRET_KEY = "CywKm1ftH2MH6oUGAQ+PCNWzsc/Ar/RuiSRl6tx/";
	private static final String BUCKET_ACCESS_KEY = "AKIAY2WTUAQRNXNOTDNC";

	public static void addConfigurationFromAWS() {
		Properties configObject = fetchConfigFile(Properties.class);
		configObject.entrySet().forEach(prop -> {
			System.setProperty(prop.getKey().toString(), prop.getValue().toString());
		});
		int nsec = Integer.parseInt(configObject.get("nsec").toString());
		Integer nmil = nsec * 1000;
		System.setProperty("nmil", nmil.toString());
	}

	public static <R> R fetchConfigFile(Class<R>configFileClass) {
		S3ClientService s3 = new S3ClientService(getAmazonS3Cient());
		return s3.downloadConfig(BUCKET_CONFIG_NAME, CONFIG_FILE_NAME, configFileClass);
	}
	
	public static  JsonElement fetchConfigFile() {
		S3ClientService s3 = new S3ClientService(getAmazonS3Cient());
		return s3.downloadConfig(BUCKET_CONFIG_NAME, CONFIG_FILE_NAME);
	}

	private static AmazonS3 getAmazonS3Cient() {
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(BUCKET_ACCESS_KEY, BUCKET_SECRET_KEY);
		// Get AmazonS3 client and return the s3Client object.
		return AmazonS3ClientBuilder.standard().withRegion(Regions.fromName("us-east-1"))
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).build();
	}
}
