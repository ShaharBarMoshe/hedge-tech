package com.hedgetech;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hedgetech.utils.AWSUtil;

@EnableScheduling
@SpringBootApplication
public class HedgeTechApplication {

	
	public static void main(String[] args) {
		AWSUtil.addConfigurationFromAWS();
		SpringApplication.run(HedgeTechApplication.class, args);
	}
}

