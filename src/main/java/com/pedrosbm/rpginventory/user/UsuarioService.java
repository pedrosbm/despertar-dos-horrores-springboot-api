package com.pedrosbm.rpginventory.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public ResponseEntity<Usuario> getUser(Long id) {
        Usuario user = repository.findById(id).get();
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<Usuario> newUser(Usuario usuario) {
        return ResponseEntity.ok(repository.save(usuario));
    }

    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario, @PathVariable Long id) {
        Boolean exists = repository.existsById(id);   
        usuario.setId(id);

        return exists? ResponseEntity.ok(repository.save(usuario)): ResponseEntity.notFound().build();
    } 

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
