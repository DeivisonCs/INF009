package com.usuario.usuario_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario.usuario_ms.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
