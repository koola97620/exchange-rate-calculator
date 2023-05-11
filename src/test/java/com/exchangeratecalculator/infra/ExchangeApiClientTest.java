package com.exchangeratecalculator.infra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
class ExchangeApiClientTest {
    @Autowired
    private ExchangeApiClient exchangeApiClient;

    @Value("${apiKey}")
    private String apiKey;

    @Test
    void convert() {
        ExchangeApiResponse exchangeRate = exchangeApiClient.getExchangeRate(apiKey, "KRW", 10);
        assertThat(exchangeRate.date()).isEqualTo(LocalDate.now());
    }

    @Test
    void list() {
        ExchangeRatesListApiResponse response = exchangeApiClient.getExchangeRateList(apiKey, "USD", "KRW,JPY,PHP");
        System.out.println(response);
    }

}
