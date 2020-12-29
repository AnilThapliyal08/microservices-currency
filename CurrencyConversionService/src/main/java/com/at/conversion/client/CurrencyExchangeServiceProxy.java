package com.at.conversion.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.at.conversion.controller.CurrencyCoversionBean;

//@FeignClient(name="currency-exchange-service",url="localhost:8001")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyCoversionBean retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to); 
}
