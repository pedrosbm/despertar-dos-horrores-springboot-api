package com.pedrosbm.rpginventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.rpginventory.models.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    Page<Personagem> findByUsuarioUserId(Long userId, Pageable pageable);
}
