package com.pedrosbm.rpginventory.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> newUser(@RequestBody Usuario usuario) {
        return service.newUser(usuario);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario, @PathVariable Long id) {
        return service.updateUser(usuario, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return service.deleteUser(id);
    }

}