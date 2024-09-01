package com.pedrosbm.rpginventory.Aura;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/aura")
public class AuraController {

    @Autowired
    AuraRepository repository;
    
    @GetMapping("/Personagem/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<List<Aura>> getAurasByCharacter(@PathVariable Long id) {
        List<Aura> lista = repository.findByPersonagemId(id);
        
        return ResponseEntity.ok(lista);
    }
    

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Aura> getAura(@PathVariable Long id) {
        try {
            Aura Aura = repository.findById(id).get();
            
            return ResponseEntity.ok(Aura);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Aura> newAura(@RequestBody Aura Aura) {
        return ResponseEntity.ok(repository.save(Aura));
    }
    
    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Aura> updateAura(@RequestBody Aura Aura, @PathVariable Long id) {
        Boolean exists = repository.existsById(id);   

        return exists? ResponseEntity.ok(repository.save(Aura)): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> deleteAura(@PathVariable Long id) {
        Boolean exists = repository.existsById(id);

        if (exists) {
            repository.deleteById(id);
            return ResponseEntity.ok("Aura removida");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
