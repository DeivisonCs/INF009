package br.edu.ifba.blog.entities;

import br.edu.ifba.blog.dtos.PostDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String titulo;
    private String texto;
    @ManyToOne
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    private Categoria categoria= Categoria.POLITICA;
    
	public Post(PostDTO postDTO, Usuario usuario) {
		this.titulo = postDTO.titulo();
		this.texto = postDTO.texto();
		this.categoria = postDTO.categoria();
		this.usuario = usuario;
	}
}
