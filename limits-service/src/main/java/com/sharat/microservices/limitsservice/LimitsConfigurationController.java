package com.sharat.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping(path = "/limits")
	public LimitConfiguration retrieveLimitsConfiguration()
	{
		return new LimitConfiguration(configuration.getMax(), configuration.getMin());
	}
	
}
