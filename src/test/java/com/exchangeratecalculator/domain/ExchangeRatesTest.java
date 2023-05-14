package com.exchangeratecalculator.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExchangeRatesTest {

    @Test
    void convertOfDouble() {
        ExchangeRates sut = ExchangeRates.of(1234.12);

        assertThat(sut.convertViewFormat()).isEqualTo("1,234.12");
    }

    @Test
    void convertOfString() {
        ExchangeRates sut = ExchangeRates.of("1,234.12");

        assertThat(sut.convertViewFormat()).isEqualTo("1,234.12");
    }

    @Test
    void calculateRemittanceAmount() {
        ExchangeRates sut = ExchangeRates.of("1,234.12");
        String result = sut.calculateRemittanceAmount(100);

        assertThat(result).isEqualTo("123,412.00");
    }

}
