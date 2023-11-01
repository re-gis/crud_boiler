package com.merci.linda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merci.linda.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    
}
