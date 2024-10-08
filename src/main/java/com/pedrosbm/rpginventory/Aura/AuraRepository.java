package com.pedrosbm.rpginventory.Aura;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuraRepository extends JpaRepository<Aura, Long>{
    List<Aura> findByPersonagemId(Long id);
}
