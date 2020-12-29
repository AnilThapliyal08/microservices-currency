package com.at.exchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.at.exchange.bean.ExchangeValue;
import com.at.exchange.repository.ExchangeRepository;

@RestController
public class ExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(ExchangeController.class);
	@Autowired
	private ExchangeRepository exchangeRep; 

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue exchangeCurrency(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = exchangeRep.findByFromAndTo(from,to);
		logger.info("Exchange value {}",exchangeValue.getConversionMult());
		return exchangeValue;
	}
	
}
	