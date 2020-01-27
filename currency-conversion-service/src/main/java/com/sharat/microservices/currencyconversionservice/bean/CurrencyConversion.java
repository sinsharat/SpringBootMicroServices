package com.sharat.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {

	private long id;
	
	private String from;
	
	private String to;
	
	private BigDecimal quantity;
	
	private BigDecimal currencyExchangeValue;
	
	private BigDecimal conversionValue;
	
	private int port;
	
	public CurrencyConversion() {
		super();
	}
	
	public CurrencyConversion(long id, String from, String to, BigDecimal quantity, BigDecimal currencyExchangeValue,
			BigDecimal conversionValue) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.currencyExchangeValue = currencyExchangeValue;
		this.conversionValue = conversionValue;
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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCurrencyExchangeValue() {
		return currencyExchangeValue;
	}

	public void setCurrencyExchangeValue(BigDecimal currencyExchangeValue) {
		this.currencyExchangeValue = currencyExchangeValue;
	}

	public BigDecimal getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
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
		builder.append("CurrencyConversion [id=");
		builder.append(id);
		builder.append(", from=");
		builder.append(from);
		builder.append(", to=");
		builder.append(to);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", currencyExchangeValue=");
		builder.append(currencyExchangeValue);
		builder.append(", conversionValue=");
		builder.append(conversionValue);
		builder.append(", port=");
		builder.append(port);
		builder.append("]");
		return builder.toString();
	}
	
}
