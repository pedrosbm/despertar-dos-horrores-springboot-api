package com.pedrosbm.rpginventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.rpginventory.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByuserNomeAndUserPassword(String userNome, String userPassword);
}
