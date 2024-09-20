package com.pedrosbm.rpginventory.Authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pedrosbm.rpginventory.user.Usuario;
import com.pedrosbm.rpginventory.user.UsuarioRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private final UsuarioRepository userRepository;
    private Algorithm algorithm;

    public TokenService(UsuarioRepository userRepository, @Value("${jwt.secret}") String secret) {
        this.userRepository = userRepository;
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public Token create(Credentials credentials) {
        var expiresAt = LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.ofHours(-3));
        var token = JWT.create()
                .withSubject(credentials.nome())
                .withClaim("cargo", credentials.cargo())
                .withExpiresAt(expiresAt)
                .sign(algorithm);
        return new Token(token, credentials.nome());
    }

    public Usuario getUserFromToken(String token) {
        var nome = JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();

        return userRepository.findByNome(nome).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
    }
}