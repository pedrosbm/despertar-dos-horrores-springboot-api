package com.pedrosbm.rpginventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long personagemId;

    private String personagemNome;

    // atual
    private int hp;

    // atual
    private int mp;

    // 20
    private int vitalidade;

    // 0
    private int defesa;

    // 20
    private int eneru;

    // 20
    private int agilidade;

    // 10
    private int intuicao;

    // 0
    private int conhecimento;

    // 20
    private int forcaFisica;

    // 5
    private int despertarNivel;
    
    private String intensidadeAura;

    private int pontos;

    @ManyToOne
    private Usuario usuario;

    @OneToOne
    private Aura aura;
}