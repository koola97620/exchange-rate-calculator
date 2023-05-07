package com.exchangeratecalculator.infra;

import java.time.LocalDate;

public record ExchangeApiResponse(
        LocalDate date,
        RateInfo info,
        Double result
) {
}
