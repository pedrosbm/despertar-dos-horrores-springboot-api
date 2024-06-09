package com.pedrosbm.rpginventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosbm.rpginventory.models.Usuario;
import com.pedrosbm.rpginventory.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Authenticate")
public class AuthenticationController {
    
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Usuario> authenticate(@RequestBody Usuario usuario) {
        String nome = usuario.getUserNome();
        String senha = usuario.getUserPassword();

        try {
            Usuario user = repository.findByUserNomeAndUserPassword(nome, senha);
            return ResponseEntity.ok(user);
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
