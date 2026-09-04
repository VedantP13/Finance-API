package com.finance.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.finance.api.model.Transaction;
import com.finance.api.repository.TransactionRepository;

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

    public Map<String, Double> getTransactionSummary() {
        Double totalIncome = repository.sumAmountByType("INCOME");
        Double totalExpense = repository.sumAmountByType("EXPENSE");
        Double balance = totalIncome - totalExpense;

        Map<String, Double> summary = new HashMap<>();
        summary.put("totalIncome", totalIncome);
        summary.put("totalExpense", totalExpense);
        summary.put("balance", balance);

        return summary;
    }
}
