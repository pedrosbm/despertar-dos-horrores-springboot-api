package com.pedrosbm.rpginventory.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByNome(String nome);

    public Optional<Usuario> findByNomeAndSenhaAndCargo(String nome, String senha, String cargo);
}
