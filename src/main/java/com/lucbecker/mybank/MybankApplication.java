package com.lucbecker.mybank;

import com.lucbecker.mybank.domain.User;
import com.lucbecker.mybank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MybankApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MybankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(null, "Lucas Becker", "38230614024", "becker", "123", 0.0);

		userRepository.saveAll(Arrays.asList(user));
	}

}
