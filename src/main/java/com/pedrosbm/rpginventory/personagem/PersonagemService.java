package com.pedrosbm.rpginventory.personagem;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pedrosbm.rpginventory.user.Usuario;
import com.pedrosbm.rpginventory.user.UsuarioRepository;

@Service
public class PersonagemService {
    
    private PersonagemRepository personagemRepository;
    private UsuarioRepository usuarioRepository;

    public PersonagemService(PersonagemRepository personagemRepository, UsuarioRepository usuarioRepository) {
        this.personagemRepository = personagemRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<Page<Personagem>> getCharactersByUser(Long id, Pageable pageable) {
        Page<Personagem> lista = personagemRepository.findByUsuarioId(id, pageable);
        return ResponseEntity.ok(lista);
    }

    public ResponseEntity<Personagem> getCharacter(Long id) {
        Personagem personagem = personagemRepository.findById(id).get();
        return ResponseEntity.ok(personagem);
    }

    public ResponseEntity<Page<Personagem>> getAll(Pageable pageable) {
        Page<Personagem> personagens = personagemRepository.findAll(pageable);
            
        return ResponseEntity.ok(personagens);
    }

    public ResponseEntity<Personagem> newCharacter(@RequestBody Personagem personagem) {
        Optional<Usuario> user = usuarioRepository.findById(personagem.getUsuario().getId());

        personagem.setUsuario(user.get());
        return ResponseEntity.ok(personagemRepository.save(personagem));
    }

    public ResponseEntity<Personagem> updateCharacter(Personagem personagem, Long id) {
        Boolean exists = personagemRepository.existsById(id);   
        personagem.setId(id);

        return exists? ResponseEntity.ok(personagemRepository.save(personagem)): ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        Boolean exists = personagemRepository.existsById(id);

        if (exists) {
            personagemRepository.deleteById(id);
            return ResponseEntity.ok("Personagem removido");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
