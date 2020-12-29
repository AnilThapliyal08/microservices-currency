package com.at.conversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.at.conversion.client.CurrencyExchangeServiceProxy;

@RestController
public class ConversionServiceController {

	@Autowired
	private CurrencyExchangeServiceProxy currencyExchnageProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCoversionBean getConversion(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		RestTemplate restTemplate =  new RestTemplate();
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to",to);
		ResponseEntity<CurrencyCoversionBean> coversionBean = restTemplate.getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyCoversionBean.class,uriVariables);
		return new CurrencyCoversionBean(coversionBean.getBody().getFrom(), coversionBean.getBody().getTo(), coversionBean.getBody().getId(),coversionBean.getBody().getConversionMult(),BigDecimal.valueOf(0), quantity);
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCoversionBean getConversionUsingFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		CurrencyCoversionBean bean = currencyExchnageProxy.retrieveExchangeValue(from, to);
		 return new CurrencyCoversionBean(bean.getFrom(),bean.getTo(),bean.getId(),bean.getConversionMult(),BigDecimal.valueOf(0),quantity);
	}
}
