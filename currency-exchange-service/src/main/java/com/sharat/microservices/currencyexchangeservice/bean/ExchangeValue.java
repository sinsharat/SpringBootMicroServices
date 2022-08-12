package com.sharat.microservices.currencyexchangeservice.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="exchange_value")
public class ExchangeValue {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	@Column(name="conversion_value")
	private BigDecimal currencyExchangeValue;
	
	@JsonInclude()
	@Transient
	private int port;
	
	public ExchangeValue() {
		super();
	}
	
	public ExchangeValue(long id, String from, String to, BigDecimal currencyExchangeValue) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyExchangeValue = currencyExchangeValue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getCurrencyExchangeValue() {
		return currencyExchangeValue;
	}

	public void setCurrencyExchangeValue(BigDecimal currencyExchangeValue) {
		this.currencyExchangeValue = currencyExchangeValue;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExchangeValue [id=");
		builder.append(id);
		builder.append(", from=");
		builder.append(from);
		builder.append(", to=");
		builder.append(to);
		builder.append(", currencyExchangeValue=");
		builder.append(currencyExchangeValue);
		builder.append("]");
		return builder.toString();
	}
	
}
