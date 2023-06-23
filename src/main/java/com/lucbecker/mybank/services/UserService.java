package com.lucbecker.mybank.services;

import com.lucbecker.mybank.domain.User;
import com.lucbecker.mybank.dtos.UserDTO;
import com.lucbecker.mybank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public UserDTO fromDTO(User obj){
        return new UserDTO(obj.getId(), obj.getName(), obj.getCpf(), obj.getLogin(), obj.getPassword(), obj.getBalance());
    }
}
