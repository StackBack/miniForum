package com.example.service;

import com.example.domain.CustomUser;
import com.example.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepos userRepos;

    public UserService(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    public CustomUser findByEmail(String email){
        return userRepos.findByEmail(email);
    }

    public boolean addUser(CustomUser user){
        if(userRepos.existsByEmail(user.getEmail())) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepos.save(user);
        return true;
    }
}
