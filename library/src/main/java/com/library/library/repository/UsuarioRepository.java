package com.library.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.library.library.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public UserDetails findByUsername(String username);
}
