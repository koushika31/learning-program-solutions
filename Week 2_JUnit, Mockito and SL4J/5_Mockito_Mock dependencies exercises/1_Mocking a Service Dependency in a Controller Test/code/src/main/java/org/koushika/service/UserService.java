package org.koushika.service;

import org.koushika.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUserById(Long id) {
        // This will be mocked in tests
        return null;
    }
}
