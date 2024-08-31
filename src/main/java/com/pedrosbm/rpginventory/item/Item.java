package com.pedrosbm.rpginventory.item;

import com.pedrosbm.rpginventory.personagem.Personagem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String icone;

    private String nome;

    private String tipo;

    private String descricao;

    @ManyToOne
    private Personagem personagem;
}
