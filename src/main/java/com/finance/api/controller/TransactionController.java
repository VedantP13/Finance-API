package com.finance.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.api.model.Transaction;
import com.finance.api.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*") // Allows frontends to access this API
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    // GET http://localhost:8080/api/transactions
    @GetMapping
    public List<Transaction> getAll() {
        return service.getAllTransactions();
    }

    // POST http://localhost:8080/api/transactions
    @PostMapping
    public Transaction create(@Valid @RequestBody Transaction transaction) {
        return service.addTransaction(transaction);
    }

    // GET http://localhost:8080/api/transactions/type/INCOME
    @GetMapping("/type/{type}")
    public List<Transaction> getByType(@PathVariable String type) {
        return service.getTransactionsByType(type);
    }

    @GetMapping("/summary")
    public Map<String, Double> getSummary() {
        return service.getTransactionSummary();
    }
}
