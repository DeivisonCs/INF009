package com.prova1.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.prova1.prova.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public UserDetails findByUsername(String username);
}
