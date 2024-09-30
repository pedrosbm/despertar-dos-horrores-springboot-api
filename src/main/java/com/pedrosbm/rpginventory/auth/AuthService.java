package com.pedrosbm.rpginventory.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pedrosbm.rpginventory.user.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository repository;

    public ResponseEntity<AuthResponse> authenticate(Auth credentials){
        String nome = credentials.nome();
        String senha = credentials.senha();
        String cargo = credentials.cargo();

        AuthResponse user = repository.findByNomeAndSenhaAndCargo(nome, senha, cargo).map(AuthResponse::new).orElseThrow(() -> new EntityNotFoundException());
        
        return ResponseEntity.ok(user);
    }
}
