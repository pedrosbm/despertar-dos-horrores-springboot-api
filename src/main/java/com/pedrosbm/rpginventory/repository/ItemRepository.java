package com.pedrosbm.rpginventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrosbm.rpginventory.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findByPersonagemPersonagemId(Long personagemId, Pageable pageable);
}
