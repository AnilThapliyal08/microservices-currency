package com.at.conversion.controller;

import java.math.BigDecimal;

public class CurrencyCoversionBean {

	private String from;
	private String to;
	private Long id;
	private BigDecimal quantity;
	private BigDecimal conversionMult;
	private BigDecimal calculatedAmount;
	
	public CurrencyCoversionBean() {
		
	}
	
	public CurrencyCoversionBean(String from, String to, Long id, BigDecimal conversionMultiple,BigDecimal calculatedAmount,BigDecimal quantity) {
		super();
		this.from = from;
		this.to = to;
		this.id = id;
		this.quantity = quantity;
		this.calculatedAmount = conversionMultiple.multiply(quantity);
		this.conversionMult = conversionMultiple;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getConversionMult() {
		return conversionMult;
	}

	public void setConversionMult(BigDecimal conversionMultiple) {
		this.conversionMult = conversionMultiple;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	
	
}
