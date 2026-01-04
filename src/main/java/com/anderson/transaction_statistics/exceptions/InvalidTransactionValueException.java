package com.anderson.transaction_statistics.exceptions;

public class InvalidTransactionValueException extends RuntimeException {

    public InvalidTransactionValueException(String message) {
        super(message);
    }
}
