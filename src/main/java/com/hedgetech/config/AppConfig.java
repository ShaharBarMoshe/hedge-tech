package com.hedgetech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

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
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
	    propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
	    return propertySourcesPlaceholderConfigurer;
	}

}
