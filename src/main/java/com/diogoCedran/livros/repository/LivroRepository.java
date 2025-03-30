package com.diogoCedran.livros.repository;

import com.diogoCedran.livros.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
