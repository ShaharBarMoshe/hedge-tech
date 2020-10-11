package com.hedgetech.component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hedgetech.model.market.Market;
import com.hedgetech.repository.MarketRepository;

import lombok.extern.log4j.Log4j2;
import service.MarketService;
import service.PortfolioService;

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

	@Scheduled(fixedRateString ="${nmil}") // from the aws config file
	public void scheduleTaskWithFixedRate() {
		protfolioService.logProtfolioBeforeDate(format);
	}

}
