package com.sharat.microservices.currencyexchangeservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharat.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.sharat.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchnageRepository;
	
	public ExchangeValue getExchangeValue(String from, String to)
	{
		Optional<ExchangeValue> optionalExchnageValue = currencyExchnageRepository.findByFromAndTo(from, to);
		
		ExchangeValue exchangeValue = null;
		
		if (optionalExchnageValue.isPresent())
		{
			exchangeValue = optionalExchnageValue.get();
		}
		
		return exchangeValue;
	}
}
