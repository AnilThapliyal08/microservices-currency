package com.at.lightservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class LightServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightServicesApplication.class, args);
	}

}
