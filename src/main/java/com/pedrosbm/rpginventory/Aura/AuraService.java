package com.pedrosbm.rpginventory.aura;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pedrosbm.rpginventory.personagem.Personagem;
import com.pedrosbm.rpginventory.personagem.PersonagemRepository;

@Service
public class AuraService {
    AuraRepository auraRepository;
    PersonagemRepository personagemRepository;
    
    public AuraService(AuraRepository auraRepository, PersonagemRepository personagemRepository) {
        this.auraRepository = auraRepository;
        this.personagemRepository = personagemRepository;
    }

    public ResponseEntity<List<Aura>> getAurasByCharacter(@PathVariable Long id) {
        List<Aura> lista = auraRepository.findByPersonagemId(id);
        
        return ResponseEntity.ok(lista);
    }

    public ResponseEntity<Aura> getAura(@PathVariable Long id) {
        try {
            Aura Aura = auraRepository.findById(id).get();
            
            return ResponseEntity.ok(Aura);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Aura> newAura(@RequestBody Aura aura) {
        Optional<Personagem> character = personagemRepository.findById(aura.getPersonagem().getId());

        aura.setPersonagem(character.get());
        return ResponseEntity.ok(auraRepository.save(aura));
    }
    
    public ResponseEntity<Aura> updateAura(@RequestBody Aura aura, @PathVariable Long id) {
        Boolean exists = auraRepository.existsById(id);   
        aura.setId(id);

        return exists? ResponseEntity.ok(auraRepository.save(aura)): ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> deleteAura(@PathVariable Long id) {
        Boolean exists = auraRepository.existsById(id);

        if (exists) {
            auraRepository.deleteById(id);
            return ResponseEntity.ok("Aura removida");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
