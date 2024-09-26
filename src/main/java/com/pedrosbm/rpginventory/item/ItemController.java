package com.pedrosbm.rpginventory.item;

import java.util.NoSuchElementException;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemRepository repository;
     
    @GetMapping("/Personagem/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Page<Item>> getItemsByCharacter(@PathVariable Long id, @PageableDefault(size = 20) Pageable pageable) {
        Page<Item> lista = repository.findByPersonagemId(id, pageable);
        
        return ResponseEntity.ok(lista);
    }
    

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        try {
            Item Item = repository.findById(id).get();
            
            return ResponseEntity.ok(Item);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<Item> newItem(@RequestBody Item item) {
        return ResponseEntity.ok(repository.save(item));
    }
    
    @PatchMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Item> updateItem(@RequestBody Item item, @PathVariable Long id) {
        Boolean exists = repository.existsById(id);   
        item.setId(id);

        return exists? ResponseEntity.ok(repository.save(item)): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        Boolean exists = repository.existsById(id);

        if (exists) {
            repository.deleteById(id);
            return ResponseEntity.ok("Item removido");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
