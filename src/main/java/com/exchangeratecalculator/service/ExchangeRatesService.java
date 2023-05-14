package com.exchangeratecalculator.service;

import org.springframework.stereotype.Service;

@Service
public class ExchangeRatesService {

    private final ExchangeApiClientService apiClientService;

    public ExchangeRatesService(ExchangeApiClientService apiClientService) {
        this.apiClientService = apiClientService;
    }

    public void getExchangeRates(String currency) {

    }
}
