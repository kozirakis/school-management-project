package com.example.middlewear.service;

import com.example.middlewear.entity.registrationModels.UserRegistrationObject;
import com.example.middlewear.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

// The UserDetailsService interface is used to retrieve
// user-related data. It has one method named loadUserByUsername().

public interface UserService extends UserDetailsService{
    User save(UserRegistrationObject registrationObject);

    List<User> getAll();
}
