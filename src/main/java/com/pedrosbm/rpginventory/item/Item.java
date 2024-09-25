package com.pedrosbm.rpginventory.item;

import com.pedrosbm.rpginventory.personagem.Personagem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    private String tipo;
    
    private String icone;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;
}
