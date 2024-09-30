package com.pedrosbm.rpginventory.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthService service;
    
    @PostMapping
    public ResponseEntity<AuthResponse> authenticate(@RequestBody Auth crecenditals) {
        try {
            return service.authenticate(crecenditals);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
