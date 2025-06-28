package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        // Insert users
        userRepository.save(new User("Alice"));
        userRepository.save(new User("Bob"));
        userRepository.save(new User("Alice"));

        // Fetch users with name "Alice"
        List<User> alices = userRepository.findByName("Alice");

        // Check size
        assertEquals(2, alices.size());
    }
}
