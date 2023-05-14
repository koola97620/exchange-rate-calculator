package com.exchangeratecalculator.domain;

import java.text.DecimalFormat;

public class ExchangeRates {
    private final Double exchangeRates;

    private ExchangeRates(Double exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public static ExchangeRates of(Double exchangeRates) {
        return new ExchangeRates(exchangeRates);
    }

    public String convertViewFormat() {
        return new DecimalFormat("###,###.00").format(exchangeRates);
    }
}
