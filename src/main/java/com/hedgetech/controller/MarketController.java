package com.hedgetech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hedgetech.model.market.Market;

import service.MarketService;
@CrossOrigin("*")
@RestController
public class MarketController {

	@Autowired
	MarketService marketService;

	@GetMapping(path = "/marketHistory", produces = "application/json")
	public List<Market> getMarketHistory() {
		
		return marketService.calculateHistoricMarketData("USD");
	}

}
