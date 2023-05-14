package com.exchangeratecalculator.infra;

import java.util.Map;

public record ExchangeRatesListApiResponse(
        Map<String, Double> rates
) {
    public Double exchangeRatesOfCountry(String targetCountry) {
        return rates.get(targetCountry);
    }
}
