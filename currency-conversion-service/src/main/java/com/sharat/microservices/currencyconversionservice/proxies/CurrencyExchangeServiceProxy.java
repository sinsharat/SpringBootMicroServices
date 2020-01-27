package com.sharat.microservices.currencyconversionservice.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sharat.microservices.currencyconversionservice.bean.CurrencyConversion;

//@FeignClient(name="currency-exchange-service", url="localhost:8000") // connects to service using url
// @FeignClient(name="currency-exchange-service") // connects to the service using eureka
@FeignClient(name="netflix-zuul-api-gateway-server") // connects to the service using eureka via API gateway
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	// @GetMapping("/currency-exchange/from/{from}/to/{to}") used without api gateway to directly hit the exact url
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") // when used with api gateway. the invocation api application name is appended
	public CurrencyConversion retrieveCurrencyExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
	
}
