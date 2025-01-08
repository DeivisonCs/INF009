package com.usuario.usuario_ms.dto.response;

import com.usuario.usuario_ms.dto.EnderecoDTO;
import com.usuario.usuario_ms.model.Usuario;

public class UsuarioResponse {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String contactNumber;
    private EnderecoDTO address;

    public UsuarioResponse (Usuario user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.address = new EnderecoDTO(user.getAddress());
        this.contactNumber = user.getContactNumber();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public EnderecoDTO getAddress() {
        return address;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
