package com.hedgetech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hedgetech.model.instrument.Instrument;
import com.hedgetech.model.market.Market;
import com.hedgetech.repository.InstrumentRepository;
import com.hedgetech.repository.MarketRepository;

@RestController
public class InstrumentController {

	@Autowired
	InstrumentRepository instrumentRepository;

	@GetMapping(path = "/instrument", produces = "application/json")
	public List<Instrument> getAll() {
		return instrumentRepository.findAll();
	}

}
