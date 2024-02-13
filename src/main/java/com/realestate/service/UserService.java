package com.realestate.service;

import com.realestate.entity.User;
import com.realestate.payload.UserDto;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    // Additional methods if needed
}
