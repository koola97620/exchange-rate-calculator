package com.exchangeratecalculator.application;

import com.exchangeratecalculator.domain.ExchangeRates;
import com.exchangeratecalculator.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.BDDMockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ExchangeRatesServiceTest {

    ExchangeApiClientService exchangeApiClientService = mock(ExchangeApiClientService.class);
    ExchangeRatesService sut = new ExchangeRatesService(exchangeApiClientService);


    @ParameterizedTest
    @NullAndEmptySource
    void validation(String input) {
        assertThatThrownBy(() -> sut.getExchangeRates(input))
                .isInstanceOf(ValidationException.class);
    }

    @Test
    void success() {
        given(exchangeApiClientService.getExchangeRates("KRW"))
                .willReturn(ExchangeRates.of(1119.123456));

        String result = sut.getExchangeRates("KRW");

        assertThat(result).isEqualTo("1,119.12");
    }

}
