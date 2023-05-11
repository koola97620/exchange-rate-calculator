package com.exchangeratecalculator.api;

import com.exchangeratecalculator.service.GetExchangeRatesListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetExchangeRatesListApi {

    private final GetExchangeRatesListService service;

    public GetExchangeRatesListApi(GetExchangeRatesListService service) {
        this.service = service;
    }
    @GetMapping("/api/exchangerates")
    public ResponseEntity<?> getExchangeRatesList(@RequestParam String currency) {
        service.getExchangeRatesList(currency);
        return ResponseEntity.ok().build();
    }
}
