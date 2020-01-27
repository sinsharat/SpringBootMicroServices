package com.sharat.microservices.currencyexchangeservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sharat.microservices.currencyexchangeservice.bean.ExchangeValue;

@Repository
public interface CurrencyExchangeRepository extends CrudRepository<ExchangeValue, Long> {

	public Optional<ExchangeValue> findByFromAndTo(String from, String to);
	
}
