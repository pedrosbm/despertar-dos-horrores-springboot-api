package com.pedrosbm.rpginventory.personagem;

import com.pedrosbm.rpginventory.user.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;

    // Atributos
    private Long hp;
    private Long eneru;
    private Long intuicao;
    private Long agilidade;
    private Long nivelDespertar;

    // status
    private int hpAtual;
    private int eneruAtual;

    @Lob
    private byte[] personagemImagem;

    @ManyToOne
    private Usuario usuario;
}