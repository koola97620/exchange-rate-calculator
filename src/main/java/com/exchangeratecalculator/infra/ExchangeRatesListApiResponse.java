package com.exchangeratecalculator.infra;

import java.time.LocalDate;
import java.util.Map;

public record ExchangeRatesListApiResponse(
        String base,
        LocalDate date,
        Map<String,Double> rates
) {
    public Double exchangeRatesOfCountry(String targetCountry) {
        return rates.get(targetCountry);
    }
}
