package com.at.exchange.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {

	@Column(name="currency_from")
	private String from;
	private String to;
	@Id
	private Long id;
	private BigDecimal conversionMult;
	
	
	public ExchangeValue(){
		
	}
	
	public ExchangeValue(String from, String to, Long id, BigDecimal conversionMult) {
		super();
		this.from = from;
		this.to = to;
		this.id = id;
		this.conversionMult = conversionMult;
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
	public BigDecimal getConversionMult() {
		return conversionMult;
	}
	public void setConversionMult(BigDecimal conversionMult) {
		this.conversionMult = conversionMult;
	}

	
	
	
}
