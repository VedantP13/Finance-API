package com.finance.api.repository;

import com.finance.api.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    Iterable<Transaction> findByType(String type);
}