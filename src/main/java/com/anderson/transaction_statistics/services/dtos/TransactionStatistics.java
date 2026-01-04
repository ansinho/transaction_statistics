package com.anderson.transaction_statistics.services.dtos;

import java.math.BigDecimal;

public record TransactionStatistics(
        BigDecimal sum,
        BigDecimal average,
        BigDecimal max,
        BigDecimal min,
        long count) {

    public static TransactionStatistics empty() {
        return new TransactionStatistics(
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                0L);
    }
}
