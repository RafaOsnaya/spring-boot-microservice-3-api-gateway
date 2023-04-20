package com.ro.springbootmicroservice3apigateway.service;

import com.ro.springbootmicroservice3apigateway.model.Role;
import com.ro.springbootmicroservice3apigateway.model.User;
import com.ro.springbootmicroservice3apigateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setFechaCreacion(LocalDateTime.now());

        return userRepository.save(user);

    }

    @Override
    public Optional<User> findByUserName(String username){
        return userRepository.findByUserName(username);

    }

    @Transactional
    @Override
    public void changeRole(Role newRole, String username){
        userRepository.updateUserRole(username, newRole);
    }



}
