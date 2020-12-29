package com.at.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.at.exchange.bean.ExchangeValue;

public interface ExchangeRepository extends JpaRepository<ExchangeValue, Long>{

	public ExchangeValue findByFromAndTo(String from,String to);
}
