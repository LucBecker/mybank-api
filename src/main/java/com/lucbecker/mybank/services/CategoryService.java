package com.lucbecker.mybank.services;

import com.lucbecker.mybank.domain.Transaction;
import com.lucbecker.mybank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private TransactionRepository repository;

    public List<Transaction> findAll() {
        return repository.findAll();
    }
}
