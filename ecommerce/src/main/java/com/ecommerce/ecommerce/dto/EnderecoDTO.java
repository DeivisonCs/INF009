package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.model.Endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
    @NotNull(message = "Rua não pode ser nula")
    @NotBlank(message = "Rua não pode estar em branco")
    @Schema(name = "rua", example = "Rua Tal de Tal") String rua, 

    @NotNull(message = "Número não pode ser nulo")
    @NotBlank(message = "Número não pode estar em branco")
    @Schema(name = "numero", example = "(71) 99818-1928") String numero, 

    @NotNull(message = "Cidade não pode ser nula")
    @NotBlank(message = "Cidade não pode estar em branco")
    @Schema(name = "cidade", example = "Fortal City") String cidade, 

    @NotNull(message = "Estado não pode ser nulo")
    @NotBlank(message = "Estado não pode estar em branco")
    @Schema(name = "estado", example = "Longe Daqui") String estado, 

    @NotNull(message = "CEP não pode ser nulo")
    @NotBlank(message = "CEP não pode estar em branco")
    @Schema(name = "cep", example = "40020-000") String cep) {

    
    public EnderecoDTO(Endereco endereco){
        this(
            endereco.getRua(),
            endereco.getNumero(),
            endereco.getCep(),
            endereco.getCidade(),
            endereco.getEstado()
        );
    }
}
