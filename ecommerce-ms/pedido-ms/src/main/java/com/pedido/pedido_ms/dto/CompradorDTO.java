package com.pedido.pedido_ms.dto;

import com.pedido.pedido_ms.model.Comprador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompradorDTO {

    private Long id;
    private String name;
    private String cpf;
    private String contactNumber;
    private String email;
    private EnderecoDTO address;

    public CompradorDTO(Comprador buyer){
        this.id = buyer.getId();
        this.name = buyer.getName();
        this.cpf = buyer.getCpf();
        this.contactNumber = buyer.getContactNumber();
        this.email = buyer.getEmail();
        this.address = new EnderecoDTO(buyer.getAddress());
    }
    
}
