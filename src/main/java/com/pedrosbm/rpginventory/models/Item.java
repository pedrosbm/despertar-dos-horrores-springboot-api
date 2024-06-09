package com.pedrosbm.rpginventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long itemId;

    private String itemIcone;

    private String itemNome;

    private String itemTipo;

    private String itemDescricao;
}
