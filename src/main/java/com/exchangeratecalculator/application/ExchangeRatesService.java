package com.exchangeratecalculator.application;

import com.exchangeratecalculator.domain.ExchangeRates;
import com.exchangeratecalculator.exception.ValidationException;
import com.exchangeratecalculator.exception.ValidationExceptionMessage;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

@Service
public class ExchangeRatesService {

    private final ExchangeApiClientService apiClientService;

    public ExchangeRatesService(ExchangeApiClientService apiClientService) {
        this.apiClientService = apiClientService;
    }

    public String getExchangeRates(String targetCurrency) {
        validate(targetCurrency);
        ExchangeRates exchangeRates = apiClientService.getExchangeRates(targetCurrency);
        return exchangeRates.convertViewFormat();
    }

    private void validate(String targetCountry) {
        if (StringUtils.isEmpty(targetCountry)) {
            throw new ValidationException(ValidationExceptionMessage.REQUEST_EMPTY);
        }
    }
}
