package com.pedrosbm.rpginventory.personagem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    Page<Personagem> findByUsuarioUserId(Long userId, Pageable pageable);
}
