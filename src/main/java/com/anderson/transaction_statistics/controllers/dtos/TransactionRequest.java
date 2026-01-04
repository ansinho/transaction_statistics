package com.anderson.transaction_statistics.controllers.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TransactionRequest(

    @NotNull(message = "Informe o valor da transação")
    @Positive(message = "O valor da transação deve ser positivo")
    BigDecimal value) {
}
