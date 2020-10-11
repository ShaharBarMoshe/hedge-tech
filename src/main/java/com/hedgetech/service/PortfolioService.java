package com.hedgetech.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hedgetech.model.portfolio.Portfolio;
import com.hedgetech.repository.PortfolioRepository;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PortfolioService {
	@Autowired
	PortfolioRepository portfolioRepository;
	private Date executionDate;
	
	@PostConstruct
    private void postConstruct() {
		setExecutionDate(calcRandDate());
	}

	
	private Date calcRandDate() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(gc.YEAR, 2019);
		int dayOfYear = 1 + (int) Math.round(Math.random() * (365 - 1));
		gc.set(gc.DAY_OF_YEAR, dayOfYear);
		return gc.getTime();
	}
	
	public Optional<Portfolio> findProtfolioBeforeDate() {
		List<Portfolio> protfolioBeforeList = portfolioRepository
				.findByTimestampLessThanEqualOrderByTimestampDesc(getExecutionDate());
		return protfolioBeforeList.stream().findFirst();
	}

	public void logProtfolioBeforeDate(SimpleDateFormat format) {
		Optional<Portfolio> protfolioBefore = findProtfolioBeforeDate();
		String executionDateFormatted = format.format(getExecutionDate());
		protfolioBefore.ifPresentOrElse(p -> {
			log.info("latest portfolio date before execution date. portfolio : " + p + "execution date: "
					+ executionDateFormatted);
		}, () -> log.warn("no protfolio found before execution date" + executionDateFormatted));
		
	}


	public Date getExecutionDate() {
		return executionDate;
	}


	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	
}
