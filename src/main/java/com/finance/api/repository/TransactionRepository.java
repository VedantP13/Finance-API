package com.finance.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance.api.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    Iterable<Transaction> findByType(String type);

    // Custom query to sum amounts by type. COALESCE prevents null errors if the database is empty.
    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t WHERE t.type = :type")
    Double sumAmountByType(@Param("type") String type);
}