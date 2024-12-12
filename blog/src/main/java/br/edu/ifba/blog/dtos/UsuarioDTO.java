package br.edu.ifba.blog.dtos;

import java.util.List;

import br.edu.ifba.blog.entities.Usuario;

public record UsuarioDTO(Long id, String nome, String login, String senha, List<RoleDto> roles) {
	
		public UsuarioDTO(Usuario usuario) {
            this(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getRoles().stream().map(RoleDto::new).toList());
        }
}
