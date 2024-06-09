package com.pedrosbm.rpginventory.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosbm.rpginventory.models.Personagem;
import com.pedrosbm.rpginventory.repository.PersonagemRepository;

import jakarta.persistence.Entity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestParam;


    
@RestController
@Entity
public class PersonagemController {
    @Autowired
    private PersonagemRepository repository;
     
    @GetMapping("/{id}")
    public ResponseEntity<Page<Personagem>> getCharactersByUser(@RequestParam String param, @PageableDefault(size = 5) Pageable pageable) {
        Page<Personagem>
        

    }
    

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Personagem> getCharacter(@PathVariable Long personagemId) {
        try {
            Personagem personagem = repository.findById(personagemId).get();
            
            return ResponseEntity.ok(personagem);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Personagem> newCharacter(@RequestBody Personagem Personagem) {
        return ResponseEntity.ok(repository.save(Personagem));
    }
    
    @PutMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Personagem> updateCharacter(@RequestBody Personagem Personagem) {
        Boolean exists = repository.existsById(Personagem.getPersonagemId());   

        return exists? ResponseEntity.ok(repository.save(Personagem)): ResponseEntity.notFound().build();
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> deleteCharacter(@RequestBody Personagem Personagem) {
        Boolean exists = repository.existsById(Personagem.getPersonagemId());

        if (exists) {
            repository.delete(Personagem);
            return ResponseEntity.ok("Personagem removido");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}   
