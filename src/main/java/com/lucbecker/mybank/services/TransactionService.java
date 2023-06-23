package com.lucbecker.mybank.services;

import com.lucbecker.mybank.domain.Transaction;
import com.lucbecker.mybank.domain.User;
import com.lucbecker.mybank.dtos.TransactionDTO;
import com.lucbecker.mybank.repositories.TransactionRepository;
import com.lucbecker.mybank.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<Transaction> findAll(){
        return repository.findAll();
    }

    public Transaction findById(Integer id){
        Optional<Transaction> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Transaction.class.getName()));
    }

    public List<Transaction> findByUser(User user){
        return repository.findByUser(user);
    }

    public TransactionDTO fromDTO(Transaction obj) {
        return new TransactionDTO(obj);
    }
}
