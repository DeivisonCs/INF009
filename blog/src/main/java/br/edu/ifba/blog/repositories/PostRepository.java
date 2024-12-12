package br.edu.ifba.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	public List<Post> findByTitulo(String titulo);
	public List<Post> findByUsuarioNome(String nome);
	public List<Post> findByTituloContaining(String titulo);
}
