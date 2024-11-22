package com.ecommerce.ecommerce.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    

}
