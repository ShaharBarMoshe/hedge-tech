package com.hedgetech.component;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hedgetech.service.MarketService;
import com.hedgetech.service.PortfolioService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ScheduledTasks {

	@Autowired
	PortfolioService protfolioService;
	@Autowired
	MarketService marketService;
	
	@Value("${hist}")
	String hist;
	
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Scheduled(fixedRateString ="${nmil:2000}") // from the aws config file
	public void scheduleTaskWithFixedRate() {
		protfolioService.logProtfolioBeforeDate(format);
	}

}
