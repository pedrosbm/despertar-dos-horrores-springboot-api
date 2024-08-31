package com.pedrosbm.rpginventory.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByuserNomeAndUserPassword(String userNome, String userPassword);
}
