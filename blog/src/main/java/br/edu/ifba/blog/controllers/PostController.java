package br.edu.ifba.blog.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifba.blog.dtos.PostDTO;
import br.edu.ifba.blog.services.PostService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	
	private PostService postService;
	
	public PostController(PostService postService){
        this.postService = postService;
    }
	
	
	@GetMapping
	@Secured("ROLE_USER")
	public List<PostDTO> listar() {
		return postService.listar();
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<PostDTO> cadastrar(@RequestBody @Valid PostDTO postDTO, UriComponentsBuilder uriBuilder) {
		return postService.cadastrar(postDTO, uriBuilder);
	}
	
	@PutMapping
	public void atualizar() {
		// postService.atualizar(postDTO);
		System.out.println("POST Atualizado com sucesso!");
	}
	
	@DeleteMapping
	public void deletar() {
		// postService.deletar(postDTO);
		System.out.println("POST Deletado com sucesso!");
	}
	
}
