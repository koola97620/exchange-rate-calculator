package com.exchangeratecalculator.application;

import com.exchangeratecalculator.domain.ExchangeRates;

public interface ExchangeApiClientService {

    ExchangeRates getExchangeRates(String targetCurrency);
}
