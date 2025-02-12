package com.currencyconversion.serviceproxy;

import com.currencyconversion.dto.CurrencyConversionBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyFallBack implements CurrencyExchangeServiceProxy{
    public CurrencyConversionBean retrieveExchangeValue(String from, String to) {
        CurrencyConversionBean response = new CurrencyConversionBean(0L, from, to, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 0);
        return response;
    }
}
