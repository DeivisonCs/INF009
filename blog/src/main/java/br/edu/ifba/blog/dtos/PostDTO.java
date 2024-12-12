package br.edu.ifba.blog.dtos;

import br.edu.ifba.blog.entities.Categoria;
import br.edu.ifba.blog.entities.Post;
import jakarta.validation.constraints.NotNull;

public record PostDTO(Long id, @NotNull(message = "O título não pode ser nulo")  String titulo, String texto, String usuario, Categoria categoria) {

	public PostDTO(Post post) {
        this(post.getId(), post.getTitulo(), post.getTexto(), post.getUsuario().getNome(), post.getCategoria());
    }
	
}
