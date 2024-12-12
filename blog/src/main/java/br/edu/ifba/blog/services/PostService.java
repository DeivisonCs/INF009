package br.edu.ifba.blog.services;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifba.blog.dtos.PostDTO;
import br.edu.ifba.blog.entities.Post;
import br.edu.ifba.blog.entities.Usuario;
import br.edu.ifba.blog.repositories.PostRepository;
import br.edu.ifba.blog.repositories.UsuarioRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	private UsuarioRepository usuarioRepository;
			
	public PostService(PostRepository postRepository, UsuarioRepository usuarioRepository) {
		this.postRepository = postRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<PostDTO> listar() {
		
		return postRepository.findAll().stream().map(PostDTO::new).toList();
	}
	
	public  ResponseEntity<PostDTO> cadastrar(PostDTO postDTO, UriComponentsBuilder uriBuilder) {
		Usuario usuario= usuarioRepository.findByNome(postDTO.usuario());
		Post newPost= new Post(postDTO, usuario);
		postRepository.save(newPost);
		URI uri= uriBuilder.path("/posts/{id}").buildAndExpand(newPost.getId()).toUri();
		return ResponseEntity.created(uri).body(new PostDTO(newPost));
	}
	
}
