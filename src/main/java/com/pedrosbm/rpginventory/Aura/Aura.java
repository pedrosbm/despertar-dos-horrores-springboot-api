package com.pedrosbm.rpginventory.aura;

import com.pedrosbm.rpginventory.personagem.Personagem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "auras")
public class Aura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private boolean principal;

    private int nivel;

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;
}
