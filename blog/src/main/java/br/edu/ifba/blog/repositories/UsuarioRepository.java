package br.edu.ifba.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.ifba.blog.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByNome(String nome);
	public UserDetails findByLogin(String username);

}
