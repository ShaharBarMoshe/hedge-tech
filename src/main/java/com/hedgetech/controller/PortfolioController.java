package com.hedgetech.controller;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hedgetech.model.portfolio.Portfolio;
import com.hedgetech.repository.PortfolioRepository;

import service.PortfolioService;
import service.aws.S3ClientService;
@CrossOrigin("*")
@RestController
public class PortfolioController {

	@Autowired
	PortfolioService portfolioService;
	
	@GetMapping(path = "/portfolio/executionDate", produces = "application/json")
	public Date getExecutionDate() {
		return portfolioService.getExecutionDate();
	}
	
	@GetMapping(path = "/portfolio/firstBeforeExecutionDate", produces = "application/json")
	public List<Portfolio> getBeforeExecutionDate() {
		return List.of(portfolioService.findProtfolioBeforeDate().orElseGet(() -> new Portfolio()));
	}
}
