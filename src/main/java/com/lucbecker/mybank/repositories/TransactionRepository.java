package com.lucbecker.mybank.repositories;

import com.lucbecker.mybank.domain.Transaction;
import com.lucbecker.mybank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByUser(User user);
}
