package com.lucbecker.mybank.repositories;

import com.lucbecker.mybank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
