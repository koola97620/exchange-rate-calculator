package com.exchangeratecalculator.infra;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers(value = {"apikey: {apiKey}", "Accept: application/json", "Content-Type: application/json;charset=utf-8"})
public interface ExchangeApiClient {
    @RequestLine("GET /exchangerates_data/convert?from=USD&to={to}&amount={amount}")
    ExchangeApiResponse getExchangeRate(
            @Param("apiKey") String apiKey,
            @Param("to") String to,
            @Param("amount") Integer amount
    );
}
