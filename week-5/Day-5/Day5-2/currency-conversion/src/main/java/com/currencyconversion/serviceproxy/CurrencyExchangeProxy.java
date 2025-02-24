package com.currencyconversion.serviceproxy;

import com.currencyconversion.dto.CurrencyConversionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
@FeignClient(name = "currency-exchange" , url = "http://currency-exchange:8090")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
     CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
                                                               @PathVariable("to") String to);
}
