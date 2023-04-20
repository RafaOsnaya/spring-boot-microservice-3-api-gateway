package com.ro.springbootmicroservice3apigateway.service;

import com.ro.springbootmicroservice3apigateway.model.Role;
import com.ro.springbootmicroservice3apigateway.model.User;

import java.util.Optional;

public interface UserService{
    User saveUser(User user);

    Optional<User> findByUserName(String username);

    void changeRole(Role newRole, String username);
}
