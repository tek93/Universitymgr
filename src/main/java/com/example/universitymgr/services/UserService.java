package com.example.universitymgr.services;

import com.example.universitymgr.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User findByUsername(String username);

    List<User> findAllUser();

    User updateUser(User user);
}
