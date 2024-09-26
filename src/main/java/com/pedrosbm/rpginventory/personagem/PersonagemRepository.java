package com.pedrosbm.rpginventory.personagem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    Page<Personagem> findByUsuarioNome(String nome, Pageable pageable);
}
