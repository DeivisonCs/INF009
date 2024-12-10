package com.biblioteca.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.biblioteca.biblioteca.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public UserDetails findByUsername(String username);
}
