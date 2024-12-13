package com.prova1.prova.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequest {

    @NotBlank
    @NotNull
    private String username;
    @NotBlank
    @NotNull
    private String password;


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

}
