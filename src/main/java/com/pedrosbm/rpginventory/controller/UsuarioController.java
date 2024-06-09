package com.pedrosbm.rpginventory.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosbm.rpginventory.models.Usuario;
import com.pedrosbm.rpginventory.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/User")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Usuario> getUser(@PathVariable Long id) {
        try {
            Usuario user = repository.findById(id).get();
            
            return ResponseEntity.ok(user);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Usuario> newUser(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(repository.save(usuario));
    }
    
    @PutMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario) {
        Boolean exists = repository.existsById(usuario.getUserId());   

        return exists? ResponseEntity.ok(repository.save(usuario)): ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> deleteUser(@RequestBody Usuario usuario) {
        Boolean exists = repository.existsById(usuario.getUserId());

        if (exists) {
            repository.delete(usuario);
            return ResponseEntity.ok("Usuário removido");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
