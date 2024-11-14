package com.agenda.agenda.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest {
    @Valid
    @NotNull(message = "Por favor, informe o nome")
    private String nome;
}
