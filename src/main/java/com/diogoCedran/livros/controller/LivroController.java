package com.diogoCedran.livros.controller;

import com.diogoCedran.livros.domain.DTO.LivroDTO;
import com.diogoCedran.livros.domain.Livro;
import com.diogoCedran.livros.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/livros")
public record LivroController(LivroService livroService) {

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(livroService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> getById(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Map<Long, String>> create(@RequestBody LivroDTO livroDTO){
        Livro newLivro = livroService.create(livroDTO);
        Map<Long, String> response = Map.of(newLivro.getId(), "Livro criado!");
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<Long, String>> update(@RequestBody LivroDTO livroDTO, @PathVariable Long id){
        Livro newLivro = livroService.update(livroDTO, id);
        Map<Long, String> response = Map.of(newLivro.getId(), "Livro atualizado!");
        return ResponseEntity.status(202).body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}