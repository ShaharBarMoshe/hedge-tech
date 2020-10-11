package service.aws;

import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class S3ClientService {
	
	AmazonS3 amazonS3Client;

	@Autowired
	public S3ClientService(AmazonS3 amazonS3Cient) {
		this.amazonS3Client =  amazonS3Cient;
	}

	public <R> R downloadConfig(String bucketName, String fileName, Class<R> configFileClass ) {

		R configObject = null;
		JsonElement configJsonObj = downloadConfig(bucketName, fileName);
		configObject = new Gson().fromJson(configJsonObj, configFileClass);
		return configObject;
	}

	public  JsonElement downloadConfig(String bucketName, String fileName) {
		S3Object object = amazonS3Client.getObject(new GetObjectRequest(bucketName, fileName));
		JsonElement jsonElement = null;
		try {
			InputStreamReader jsonReader = new InputStreamReader(object.getObjectContent(), "UTF-8");
            jsonElement = JsonParser.parseReader(jsonReader);
		} catch (IOException e) {
			log.error("Can't read json file", e);
		}
		return jsonElement;
	}

}
