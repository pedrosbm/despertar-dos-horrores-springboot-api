package com.pedrosbm.rpginventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// @Entity
@Data
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long skillId;

    private String skillName;

    private String skillDescription;

    private String skillDices;

    private String skillCathegory;
 
    private int skillCost;
    
}
