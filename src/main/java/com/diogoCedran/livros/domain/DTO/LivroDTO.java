package com.diogoCedran.livros.domain.DTO;

public class LivroDTO {

    private String nome;
    private String autor;

    public LivroDTO(String nome, String autor) {
        this.nome = nome;
        this.autor = autor;
    }

    public LivroDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}