package com.biblioteca.biblioteca.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequest(
    @NotNull
    @NotBlank
    String titulo,
    @NotNull
    @NotBlank
    String autor,
    @NotNull
    @NotBlank
    Integer anoPublicacao
) {

}
