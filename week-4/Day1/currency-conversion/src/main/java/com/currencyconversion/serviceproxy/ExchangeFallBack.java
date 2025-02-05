package com.currencyconversion.serviceproxy;

import com.currencyconversion.dto.CurrencyConversionBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ExchangeFallBack implements CurrencyExchangeServiceProxy {
    @Override
    public CurrencyConversionBean retrieveExchangeValue(String from, String to) {
        return new CurrencyConversionBean(0L, from, to, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 0);
    }
}
