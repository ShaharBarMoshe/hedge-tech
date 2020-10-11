package com.hedgetech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.MarketService;
import service.PortfolioService;

@Configuration
public class AppConfig {

	@Bean
	public PortfolioService protfolioService() {
		return new PortfolioService();
	}
	
	@Bean
	public MarketService marketService() {
		return new MarketService();
	}
}
