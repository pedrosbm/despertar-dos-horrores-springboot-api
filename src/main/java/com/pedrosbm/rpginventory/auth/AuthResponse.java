package com.pedrosbm.rpginventory.auth;

import com.pedrosbm.rpginventory.user.Usuario;

public record AuthResponse(Long id, String nome) {
    public AuthResponse(Usuario usuario){
        this(usuario.getId(), usuario.getNome());
    }
} 
