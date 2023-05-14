package com.exchangeratecalculator.infra;

import com.exchangeratecalculator.domain.ExchangeRates;
import com.exchangeratecalculator.application.ExchangeApiClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRestApiClientService implements ExchangeApiClientService {
    private static final String BASE = "USD";

    private final String apiKey;
    private final ExchangeApiClient apiClient;

    public ExchangeRestApiClientService(@Value("${apiKey}") String apiKey, ExchangeApiClient apiClient) {
        this.apiKey = apiKey;
        this.apiClient = apiClient;
    }

    @Override
    public ExchangeRates getExchangeRates(String targetCurrency) {
        ExchangeRatesListApiResponse response = apiClient.getExchangeRateList(apiKey, BASE, targetCurrency);
        return ExchangeRates.of(response.exchangeRatesOfCountry(targetCurrency));
    }
}
