package com.anderson.transaction_statistics.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private BigDecimal value;
    private LocalDateTime dateTime;

    public Transaction() {
    }

    public Transaction(BigDecimal value, LocalDateTime dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
