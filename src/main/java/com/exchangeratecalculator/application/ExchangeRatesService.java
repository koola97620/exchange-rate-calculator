package com.exchangeratecalculator.application;

import com.exchangeratecalculator.domain.ExchangeRates;
import com.exchangeratecalculator.exception.InvalidAmountException;
import com.exchangeratecalculator.exception.ValidationException;
import com.exchangeratecalculator.exception.ValidationExceptionMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

@Service
public class ExchangeRatesService {

    private final ExchangeApiClientService apiClientService;

    public ExchangeRatesService(ExchangeApiClientService apiClientService) {
        this.apiClientService = apiClientService;
    }

    public String getExchangeRates(String targetCurrency) {
        validateCurrency(targetCurrency);

        ExchangeRates exchangeRates = apiClientService.getExchangeRates(targetCurrency);
        return exchangeRates.convertViewFormat();
    }

    private void validateCurrency(String targetCountry) {
        if (ObjectUtils.isEmpty(targetCountry)) {
            throw new ValidationException(ValidationExceptionMessage.REQUEST_TARGET_CURRENCY_EMPTY);
        }
    }

    public String getRemittanceAmount(String exchangeRatesString, Integer amount) {
        validateRemittanceAmount(exchangeRatesString,amount);

        ExchangeRates exchangeRates = ExchangeRates.of(exchangeRatesString);
        return exchangeRates.calculateRemittanceAmount(amount);
    }

    private void validateRemittanceAmount(String exchangeRates, Integer amount) {
        if (ObjectUtils.isEmpty(exchangeRates)) {
            throw new ValidationException(ValidationExceptionMessage.REQUEST_EXCHANGE_RATES_EMPTY);
        }

        if (ObjectUtils.isEmpty(amount) || amount <= 0) {
            throw new InvalidAmountException(ValidationExceptionMessage.REQUEST_INVALID_AMOUNT);
        }

    }
}
