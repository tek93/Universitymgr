package com.example.universitymgr.services;

import com.example.universitymgr.model.User;
import com.example.universitymgr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);

    }
    @Override
    public List<User>findAllUser(){
        return userRepository.findAll();
    }
    @Override
    public User updateUser(User user){
        return userRepository.save(user);
    }
}
