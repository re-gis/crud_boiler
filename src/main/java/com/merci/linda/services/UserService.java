package com.merci.linda.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.merci.linda.dtos.SaveDto;
import com.merci.linda.entities.User;
import com.merci.linda.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(SaveDto dto) throws Exception {
        if(dto.getEmail() == "" || dto.getPassword() == "" || dto.getUsername() == "") {
            throw new Exception("All credentials are required!");
        }

        // save user
        Optional<User> eUser = userRepository.findByEmail(dto.getEmail());
        if(eUser.isPresent()){
            throw new Exception("User already exists!");
        }

        // else save
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        
        userRepository.save(user);

        return user;
    }
}
