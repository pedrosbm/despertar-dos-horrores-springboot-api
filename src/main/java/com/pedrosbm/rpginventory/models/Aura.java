package com.pedrosbm.rpginventory.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aura {

    private String auraPrincipal;

    private String[] aurasSecundarias;

    private String[] aurasTerciarias;

    private String auraFinal;

    private Skill skills;

    @JsonCreator
    public Aura(@JsonProperty("aura") String aura){
        setAuraPrincipal(aura);
        switch (aura) {
            case "elementos":
                this.aurasSecundarias = new String[]{"telecinese", "emissao"};
                this.aurasTerciarias = new String[]{"controle de vibracao", "controle de aura"};
                this.auraFinal = "aprimoramento";
                break;
            case "telecinese":
                this.aurasSecundarias = new String[]{"elementos", "controle de aura"};
                this.aurasTerciarias = new String[]{"emissao", "aprimoramento"};
                this.auraFinal = "controle de vibracao";
                break;
            case "controle de aura":
                this.aurasSecundarias = new String[]{"telecinese", "aprimoramento"};
                this.aurasTerciarias = new String[]{"elementos", "controle de vibracao"};
                this.auraFinal = "emissao";
                break;
            case "aprimoramento":
                this.aurasSecundarias = new String[]{"controle de aura", "controle de vibracao"};
                this.aurasTerciarias = new String[]{"telecinese", "emissao"};
                this.auraFinal = "elementos";
                break;
            case "controle de vibracao":
                this.aurasSecundarias = new String[]{"emissao", "aprimoramento"};
                this.aurasTerciarias = new String[]{"controle de aura", "elementos"};
                this.auraFinal = "telecinese";
                break;
            case "emissao":
                this.aurasSecundarias = new String[]{"controle de vibracao", "elementos"};
                this.aurasTerciarias = new String[]{"aprimoramento", "telecinese"};
                this.auraFinal = "controle de aura";
                break;
            default:
                break;
        }
    }

    @JsonCreator
    public Aura(@JsonProperty("auraPrincipal") String auraPrincipal, @JsonProperty("aurasSecundarias") String[] aurasSecundarias, @JsonProperty("aurasTerciarias") String[] aurasTerciarias, @JsonProperty("auraFinal") String auraFinal){
        this.auraPrincipal = auraPrincipal;
        this.aurasSecundarias = aurasSecundarias;
        this.aurasTerciarias = aurasSecundarias;
        this.auraFinal = auraFinal;
    }
}
