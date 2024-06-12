package com.pedrosbm.rpginventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Arma{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long armaId;

    private int dano;

    private String danoMagico;

    @OneToOne
    private Item item;

    public String getDanoMagico(){

        // TODO implementar calculo do dano mágico
        return danoMagico == null? null : "exemplo dano"; 
    }
}
