package com.anderson.transaction_statistics.repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.anderson.transaction_statistics.models.Transaction;

@Repository
public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> findAll() {
        return new ArrayList<>(transactions);
    }
}
