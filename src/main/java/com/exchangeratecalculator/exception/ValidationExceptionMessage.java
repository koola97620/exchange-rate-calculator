package com.exchangeratecalculator.exception;

public class ValidationExceptionMessage {
    public static final String REQUEST_TARGET_CURRENCY_EMPTY = "수취국가정보가 비어있습니다.";
    public static final String REQUEST_EXCHANGE_RATES_EMPTY = "환율정보가 비어있습니다. 환율조회를 먼저 해야 합니다.";
    public static final String REQUEST_INVALID_AMOUNT = "송금액은 0보다 커야 합니다.";
}
