package com.pedrosbm.rpginventory.personagem;

import com.pedrosbm.rpginventory.user.Usuario;

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
@Table(name = "personagens")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String auraPrincipal;

    // Atributos
    private int hp;
    private int eneru;
    private int intuicao;
    private int agilidade;
    private int nivelDespertar;
    private int pontos;

    // status
    private int hpAtual;
    private int eneruAtual;

    private String personagemImagem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;
}