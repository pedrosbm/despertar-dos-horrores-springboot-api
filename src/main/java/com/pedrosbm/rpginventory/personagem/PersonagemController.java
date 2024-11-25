package com.pedrosbm.rpginventory.personagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
    
@RestController
@RequestMapping("/personagem")
public class PersonagemController {
    
    // TODO implement character server side events for data fetching on the client

    @Autowired
    private PersonagemService service;
     
    @GetMapping("/User/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Page<Personagem>> getCharactersByUser(@PathVariable Long id, @PageableDefault(size = 5) Pageable pageable) {
        return service.getCharactersByUser(id, pageable);
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Personagem> getCharacter(@PathVariable Long id) {
        return service.getCharacter(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Page<Personagem>> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Personagem> newCharacter(@RequestBody Personagem personagem) {
        return service.newCharacter(personagem);
    }
    
    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Personagem> updateCharacter(@RequestBody Personagem personagem, @PathVariable Long id) {
        return service.updateCharacter(personagem, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        return service.deleteCharacter(id);
    }
}   
