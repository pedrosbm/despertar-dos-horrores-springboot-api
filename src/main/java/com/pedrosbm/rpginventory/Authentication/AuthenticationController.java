package com.pedrosbm.rpginventory.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosbm.rpginventory.user.Usuario;
import com.pedrosbm.rpginventory.user.UsuarioRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Auth")
public class AuthenticationController {
    
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Usuario> authenticate(@RequestBody Usuario usuario) {
        String nome = usuario.getNome();
        String senha = usuario.getPassword();

        Usuario user = repository.findByuserNomeAndUserPassword(nome, senha);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);            
    }
    
}
