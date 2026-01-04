package com.anderson.transaction_statistics.services;

import org.springframework.stereotype.Service;

import com.anderson.transaction_statistics.exceptions.InvalidTransactionValueException;
import com.anderson.transaction_statistics.models.Transaction;
import com.anderson.transaction_statistics.repositories.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction create(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidTransactionValueException("O valor deve ser maior que zero.");
        }

        Transaction transaction = new Transaction(value, LocalDateTime.now());
        repository.save(transaction);
        return transaction;
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }
}
