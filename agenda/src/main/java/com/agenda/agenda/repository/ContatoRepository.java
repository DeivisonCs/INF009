package com.agenda.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
}
