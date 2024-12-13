package com.prova1.prova.mapper;

import com.prova1.prova.dto.request.UsuarioRequest;
import com.prova1.prova.model.Usuario;

public class UsuarioMapper {

    public static Usuario requestToModel(UsuarioRequest user){
        return new Usuario(user);
    }
}
