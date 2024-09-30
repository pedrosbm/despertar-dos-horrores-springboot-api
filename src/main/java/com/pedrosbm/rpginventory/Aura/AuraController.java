package com.pedrosbm.rpginventory.Aura;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/aura")
public class AuraController {

    @Autowired
    private AuraService service;

    @GetMapping("/Personagem/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<List<Aura>> getAurasByCharacter(@PathVariable Long id) {
        return service.getAurasByCharacter(id);
    }
    

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Aura> getAura(@PathVariable Long id) {
        return service.getAura(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Aura> newAura(@RequestBody Aura aura) {
        return service.newAura(aura);
    }
    
    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Aura> updateAura(@RequestBody Aura aura, @PathVariable Long id) {
        return service.updateAura(aura, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> deleteAura(@PathVariable Long id) {
        return service.deleteAura(id);
    }
}
