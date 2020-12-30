package com.at.lightservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitServiceController {

	@Autowired
	private Configuration configuration;
	@GetMapping("/limits")
	@HystrixCommand
	public LimitConfiguration getLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
	
	@GetMapping("/fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallbackMethod" )
	public LimitConfiguration retriveConfiguration() {
		throw new RuntimeException("Not available");
	}
	
	public LimitConfiguration fallbackMethod() {
		return new LimitConfiguration(55,5);
	}
	
	
}
