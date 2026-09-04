package com.finance.api.service;

import com.finance.api.model.Transaction;
import com.finance.api.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {
    
    private final TransactionRepository repository;

    // Spring automatically injects the repository here
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction addTransaction(Transaction transaction) {
        return repository.save(transaction);
    }
    
    public List<Transaction> getTransactionsByType(String type) {
        return (List<Transaction>) repository.findByType(type.toUpperCase());
    }
}