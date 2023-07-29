package com.driver.services;

import com.driver.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private final Map<Integer, User> userDb = new HashMap<>();

    // Add a user to the database
    public void addUser(User user) {
        userDb.put(user.getaadharCardNo(), user);
    }

    // Get a user by aadhar card number
    public User getUserByAadharCard(int aadharCardNo) {
        return userDb.get(aadharCardNo);
    }
}