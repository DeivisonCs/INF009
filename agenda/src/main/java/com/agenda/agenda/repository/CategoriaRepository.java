package com.agenda.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.agenda.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
