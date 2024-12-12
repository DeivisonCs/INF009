package br.edu.ifba.blog.entities;

import org.springframework.security.core.GrantedAuthority;

import br.edu.ifba.blog.dtos.RoleDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "roles")
public class Role implements GrantedAuthority {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;
	
	
	public Role() {
	}
	
	public Role(RoleDto roleDto) {
		this.id = roleDto.id();
		this.role = roleDto.role();
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}

	
	public Long getId() {
		return id;
	}
	
	public String getRole() {
		return role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}

