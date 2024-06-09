package com.pedrosbm.rpginventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.rpginventory.models.Personagem;
import java.util.List;


public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    List<Personagem> findByUsuarioUserId(Long userId);
}
