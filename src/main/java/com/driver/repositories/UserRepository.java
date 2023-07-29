package com.driver.repositories;

import com.driver.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    // In-memory database for users
    private final Map<Integer, User> userDb = new HashMap<>();

    // Add a user to the database
    public void addUser(User user) {
        if (user != null) {
            userDb.put(user.getaadharCardNo(), user);
        }
    }

    // Get a user by aadhar card number
    public User getUserByAadharCard(int aadharCardNo) {
        return userDb.get(aadharCardNo);
    }
}