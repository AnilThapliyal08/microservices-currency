package com.at.exchange.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.at.exchange.bean.ExchangeValue;
import com.at.exchange.repository.ExchangeRepository;

@RestController
public class ExchangeController {
	
	@Autowired
	private Environment environment;
	@Autowired
	private ExchangeRepository exchangeRep; 

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue exchangeCurrency(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = exchangeRep.findByFromAndTo(from,to);
		return exchangeValue;
	}
	
}
	