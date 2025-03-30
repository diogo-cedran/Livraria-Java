package com.diogoCedran.livros.service;

import com.diogoCedran.livros.domain.DTO.LivroDTO;
import com.diogoCedran.livros.domain.Livro;
import com.diogoCedran.livros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record LivroService(LivroRepository livroRepository) {
    public List<Livro> getAll(){
        return livroRepository.findAll();
    }

    public Livro getById(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()){
            return livro.get();
        } else {
            return null;
        }
    }

    public Livro create(LivroDTO livroDTO){
        Livro livro = new Livro(livroDTO);
        return livroRepository.save(livro);
    }

    public Livro update(LivroDTO livroDTO, Long id){
        livroRepository.findById(id).ifPresentOrElse((existingLivro) -> {
            existingLivro.setId(id);
            existingLivro.setAutor(livroDTO.getAutor());
            existingLivro.setNome(livroDTO.getNome());
            livroRepository.save(existingLivro);
        }, () -> {
            throw new RuntimeException();
        });
        return livroRepository.findById(id).get();
    }

    public void delete(Long id){
        livroRepository.deleteById(id);
    }
}
