package com.lucbecker.mybank.services;

import com.lucbecker.mybank.domain.User;
import com.lucbecker.mybank.dtos.UserDTO;
import com.lucbecker.mybank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
    public User insert(UserDTO obj) {
        User newObj = new User(null, obj.getName(), obj.getCpf(), obj.getLogin(), obj.getPassword(), obj.getBalance());
        return repository.save(newObj);
    }

    public User findById(Integer id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public UserDTO fromDTO(User obj){
        return new UserDTO(obj);
    }
}
