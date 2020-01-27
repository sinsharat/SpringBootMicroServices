package com.sharat.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sharat.microservices.currencyconversionservice.bean.CurrencyConversion;
import com.sharat.microservices.currencyconversionservice.service.CurrencyConversionService;

@RestController
public class CurrencyConversionServiceController {

	@Autowired
	private CurrencyConversionService currencyConversionService;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
	{
		CurrencyConversion currencyConversion = currencyConversionService.calculateAndFetchCurrencyConversion(from, to, quantity);
		return currencyConversion;
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveCurrencyConversionUsingFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
	{
		CurrencyConversion currencyConversion = currencyConversionService.calculateAndFetchCurrencyConversionUsingFeign(from, to, quantity);
		return currencyConversion;
	}
	
}
