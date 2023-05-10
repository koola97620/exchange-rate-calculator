package com.exchangeratecalculator.infra;

import java.time.LocalDate;
import java.util.Map;

public record ExchangeRateListApiResponse(
        String base,
        LocalDate date,
        Map<String,Double> rates
) {
}
