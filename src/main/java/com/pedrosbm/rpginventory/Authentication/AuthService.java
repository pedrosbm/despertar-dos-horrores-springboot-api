package com.pedrosbm.rpginventory.Authentication;

import com.pedrosbm.rpginventory.user.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthService(UsuarioRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public Token login(Credentials credentials) {
        System.out.println(credentials.toString());
        var user = userRepository.findByNomeAndCargo(credentials.nome(), credentials.cargo())
                .orElseThrow(() -> new RuntimeException("No user"));

        if (!passwordEncoder.matches(credentials.senha(), user.getSenha()))
            throw new RuntimeException("Wrong pass");

        return tokenService.create(credentials);
    }
}