package com.ecommerce.ecommerce.model;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.dto.request.UserRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator()
    private UUID id;
    private String nome;

    @Column(unique=true)
    private String email;
    private String senha;

    private String telefone;

    @Embedded
    private Endereco endereco;

    public User(UserRequest user){
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
        this.telefone = user.getTelefone();
        this.endereco = new Endereco(user.getEndereco());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("COMMON_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
