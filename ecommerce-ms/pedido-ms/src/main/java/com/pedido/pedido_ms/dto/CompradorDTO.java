package com.pedido.pedido_ms.dto;

import com.pedido.pedido_ms.model.Comprador;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public EnderecoDTO getAddress() {
        return address;
    }
    
    
}
