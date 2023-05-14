package com.exchangeratecalculator.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExchangeRatesTest {

    @Test
    void convert() {
        ExchangeRates sut = ExchangeRates.of(1234.12);

        assertThat(sut.convertViewFormat()).isEqualTo("1,234.12");
    }

}
