package com.pedrosbm.rpginventory.user;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
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
    
    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario, @PathVariable Long id) {
        Boolean exists = repository.existsById(id);   
        usuario.setId(id);

        return exists? ResponseEntity.ok(repository.save(usuario)): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        Boolean exists = repository.existsById(id);

        if (exists) {
            repository.deleteById(id);
            return ResponseEntity.ok("Usuário removido");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
