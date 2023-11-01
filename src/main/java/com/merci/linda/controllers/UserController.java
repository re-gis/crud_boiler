package com.merci.linda.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merci.linda.dtos.SaveDto;
import com.merci.linda.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(SaveDto dto) throws Exception {
        return ResponseEntity.ok(userService.saveUser(dto));
    }
}
