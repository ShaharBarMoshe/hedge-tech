package com.hedgetech.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.hedgetech.utils.AWSUtil;

@CrossOrigin("*")
@RestController
public class ConfigController {
	
	@GetMapping(path = "/config")
	public String getconfigFile() {
		return AWSUtil.fetchConfigFile().getAsJsonObject().toString();
	}
	

}
