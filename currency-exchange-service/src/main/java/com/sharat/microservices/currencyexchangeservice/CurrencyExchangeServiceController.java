package com.sharat.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sharat.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.sharat.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeServiceController {

//	@Value("${server.port}")
//	private int port;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveCurrencyExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = currencyExchangeService.getExchangeValue(from, to);
		if (null == exchangeValue)
		{
			exchangeValue = new ExchangeValue(-1, from, to, BigDecimal.valueOf(-1));
		}
		
		exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		return exchangeValue;
	}

}
