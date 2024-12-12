package br.edu.ifba.blog.dtos;

import br.edu.ifba.blog.entities.Role;

public record RoleDto(Long id, String role) {
	
	public RoleDto(Role role) {
		this(role.getId(), role.getRole());
	}

}
