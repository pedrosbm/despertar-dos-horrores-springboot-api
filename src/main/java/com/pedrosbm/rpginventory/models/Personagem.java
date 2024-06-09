package com.pedrosbm.rpginventory.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long personagemId;

    private int PersonagemNome;

    private String tipoAura;

    private int vitalidade;

    private int defesa;

    private int eneru;

    private int agilidade;

    private int intuicao;

    private int inteligencia;

    private int forcaFisica;

    private int despertarNivel;
    
    private String intensidadeAura;

    @ManyToOne
    private Usuario usuario;
    
    @OneToMany
    private List<Item> items;
}