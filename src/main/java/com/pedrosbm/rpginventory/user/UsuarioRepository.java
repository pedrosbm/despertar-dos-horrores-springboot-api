package com.pedrosbm.rpginventory.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByNomeAndSenha(String nome, String senha);
}
