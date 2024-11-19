package com.ecommerce.ecommerce.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest {
    @NotNull(message = "Nome nao deve ser nulo")
    @NotBlank(message = "Nome nao deve estar em branco")
    private String nome;
}
