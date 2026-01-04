package com.anderson.transaction_statistics.services;

import org.springframework.stereotype.Service;

import com.anderson.transaction_statistics.exceptions.InvalidTransactionValueException;
import com.anderson.transaction_statistics.models.Transaction;
import com.anderson.transaction_statistics.repositories.TransactionRepository;
import com.anderson.transaction_statistics.services.dtos.TransactionStatistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public TransactionStatistics findStatistics(Long seconds) {

        LocalDateTime limit = LocalDateTime.now()
                .minusSeconds(seconds);

        List<Transaction> transactions = repository.findAfter(limit);

        if (transactions.isEmpty()) {
            return TransactionStatistics.empty();
        }

        long count = transactions.size();

        BigDecimal sum = transactions.stream()
                .map(Transaction::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal average = sum.divide(
                BigDecimal.valueOf(count),
                2,
                RoundingMode.HALF_UP);

        BigDecimal max = transactions.stream()
                .map(Transaction::getValue)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        BigDecimal min = transactions.stream()
                .map(Transaction::getValue)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        TransactionStatistics stats = new TransactionStatistics(sum, average, max, min, count);
        return stats;
    }
}