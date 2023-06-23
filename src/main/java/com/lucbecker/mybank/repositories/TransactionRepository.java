package com.lucbecker.mybank.repositories;

import com.lucbecker.mybank.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
