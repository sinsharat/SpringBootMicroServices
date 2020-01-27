package com.sharat.microservices.currencyconversionservice.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sharat.microservices.currencyconversionservice.bean.CurrencyConversion;
import com.sharat.microservices.currencyconversionservice.proxies.CurrencyExchangeServiceProxy;

@Service
public class CurrencyConversionService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	public CurrencyConversion calculateAndFetchCurrencyConversion(String from, String to, BigDecimal quantity)
	{
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		CurrencyConversion currencyConversion = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables).getBody();
		currencyConversion.setQuantity(quantity);
		currencyConversion.setConversionValue(currencyConversion.getCurrencyExchangeValue().multiply(currencyConversion.getQuantity()));
		
		return currencyConversion;
	}
	
	public CurrencyConversion calculateAndFetchCurrencyConversionUsingFeign(String from, String to, BigDecimal quantity)
	{
		CurrencyConversion currencyConversion = currencyExchangeServiceProxy.retrieveCurrencyExchangeValue(from, to);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setConversionValue(currencyConversion.getCurrencyExchangeValue().multiply(currencyConversion.getQuantity()));
		
		return currencyConversion;
	}
	
}
