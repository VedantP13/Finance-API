package com.finance.api.controller;

import com.finance.api.model.Transaction;
import com.finance.api.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
}