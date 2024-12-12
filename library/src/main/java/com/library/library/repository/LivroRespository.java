package com.library.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.model.Livro;

public interface LivroRespository extends JpaRepository<Livro, Long>{

}
