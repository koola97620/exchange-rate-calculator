package com.exchangeratecalculator.application;

import com.exchangeratecalculator.domain.ExchangeRates;
import com.exchangeratecalculator.exception.InvalidAmountException;
import com.exchangeratecalculator.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ExchangeRatesServiceTest {

    ExchangeApiClientService exchangeApiClientService = mock(ExchangeApiClientService.class);
    ExchangeRatesService sut = new ExchangeRatesService(exchangeApiClientService);


    @ParameterizedTest
    @NullAndEmptySource
    void getExchangeRates_inValidate(String input) {
        assertThatThrownBy(() -> sut.getExchangeRates(input))
                .isInstanceOf(ValidationException.class);
    }

    @Test
    void getExchangeRates_success() {
        given(exchangeApiClientService.getExchangeRates("KRW"))
                .willReturn(ExchangeRates.of(1119.123456));

        String result = sut.getExchangeRates("KRW");

        assertThat(result).isEqualTo("1,119.12");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void getRemittanceAmount_inValidate_exchangeRates(String input) {
        assertThatThrownBy(() -> sut.getRemittanceAmount(input, 100))
                .isInstanceOf(ValidationException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @NullSource
    void getRemittanceAmount_inValidate_amount(Integer input) {
        assertThatThrownBy(() -> sut.getRemittanceAmount("1,234.12", input))
                .isInstanceOf(InvalidAmountException.class);
    }

    @Test
    void getRemittanceAmount_success() {
        String result = sut.getRemittanceAmount("1,234.12", 100);

        assertThat(result).isEqualTo("123,412.00");
    }

}
