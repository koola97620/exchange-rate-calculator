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

    public static ExchangeRates of(String exchangeRates) {
        return new ExchangeRates(
                Double.valueOf(exchangeRates.replaceAll(",", ""))
        );
    }

    public String convertViewFormat() {
        return createStringFormat(exchangeRates);
    }

    public String calculateRemittanceAmount(Integer amount) {
        double remittanceAmount = exchangeRates * amount;
        return createStringFormat(remittanceAmount);
    }

    private String createStringFormat(Double target) {
        return new DecimalFormat("###,###.00").format(target);
    }
}
