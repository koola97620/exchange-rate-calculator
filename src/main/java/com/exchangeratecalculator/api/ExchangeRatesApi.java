package com.exchangeratecalculator.api;

import com.exchangeratecalculator.application.ExchangeRatesService;
import feign.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRatesApi {

    private final ExchangeRatesService service;

    public ExchangeRatesApi(ExchangeRatesService service) {
        this.service = service;
    }
    @GetMapping("/api/exchangerates")
    public ResponseEntity<?> getExchangeRates(@RequestParam String targetCurrency) {
        return ResponseEntity.ok(service.getExchangeRates(targetCurrency));
    }

    @GetMapping("/api/exchangerates/remittance")
    public ResponseEntity<?> getRemittanceAmount(@RequestParam String exchangeRates, @RequestParam Integer amount) {
        return ResponseEntity.ok(service.getRemittanceAmount(exchangeRates, amount));
    }
}
