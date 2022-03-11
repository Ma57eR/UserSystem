package com.example;

import com.example.entities.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    public ConsoleRunner(UserRepository userReposiroty) {
        this.userRepository = userReposiroty;
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User("Ivan", "Petkov", "abv@abv.bg", 20, "Ivan", "Ivanov");

        userRepository.save(user);

    }
}
