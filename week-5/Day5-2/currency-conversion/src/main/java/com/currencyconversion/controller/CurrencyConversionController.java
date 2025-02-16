package com.currencyconversion.controller;

import com.currencyconversion.dto.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.currencyconversion.serviceproxy.CurrencyExchangeProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {

		// Call currency-exchange service using FeignClient
		CurrencyConversionBean conversionBean = currencyExchangeProxy.retrieveExchangeValue(from, to);

		logger.info("Retrieved exchange value: {}", conversionBean);

		return new CurrencyConversionBean(
				conversionBean.getId(),
				from,
				to,
				conversionBean.getConversionMultiple(),
				quantity,
				quantity.multiply(conversionBean.getConversionMultiple()),
				conversionBean.getPort()
		);
	}
}