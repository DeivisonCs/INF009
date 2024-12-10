package com.ecommerce.ecommerce.model;

import com.ecommerce.ecommerce.dto.EnderecoDTO;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Endereco {

    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    
    public Endereco(EnderecoDTO endereco){
        this.rua = endereco.rua();
        this.numero = endereco.numero();
        this.cidade = endereco.cidade();
        this.estado = endereco.estado();
        this.cep = endereco.cep();
    }
}
