package com.pedrosbm.rpginventory.personagem;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pedrosbm.rpginventory.user.Usuario;
import com.pedrosbm.rpginventory.user.UsuarioRepository;

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
    
    private PersonagemRepository repository;
    private UsuarioRepository repository2;

    public PersonagemController(PersonagemRepository repository, UsuarioRepository repository2){
        this.repository = repository;
        this.repository2 = repository2;
    }
     
    @GetMapping("/User/{nome}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Page<Personagem>> getCharactersByUser(@PathVariable String nome, @PageableDefault(size = 5) Pageable pageable) {
        Page<Personagem> lista = repository.findByUsuarioNome(nome, pageable);
        
        return ResponseEntity.ok(lista);
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Personagem> getCharacter(@PathVariable Long id) {
        try {
            Personagem personagem = repository.findById(id).get();
            
            return ResponseEntity.ok(personagem);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Page<Personagem>> getAll(Pageable pageable) {
        try {
            Page<Personagem> personagens = repository.findAll(pageable);
            
            return ResponseEntity.ok(personagens);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Personagem> newCharacter(@RequestBody Personagem personagem) {
        Optional<Usuario> user = repository2.findByNome(personagem.getUsuario().getNome());

        personagem.setUsuario(user.get());
        return ResponseEntity.ok(repository.save(personagem));
    }
    
    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Personagem> updateCharacter(@RequestBody Personagem personagem, @PathVariable Long id) {
        Boolean exists = repository.existsById(id);   
        personagem.setId(id);

        return exists? ResponseEntity.ok(repository.save(personagem)): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> deleteCharacter(@PathVariable Long id) {
        Boolean exists = repository.existsById(id);

        if (exists) {
            repository.deleteById(id);
            return ResponseEntity.ok("Personagem removido");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}   
