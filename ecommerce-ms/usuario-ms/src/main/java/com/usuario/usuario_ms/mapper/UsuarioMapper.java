package com.usuario.usuario_ms.mapper;

import com.usuario.usuario_ms.dto.request.UsuarioRequest;
import com.usuario.usuario_ms.dto.response.UsuarioResponse;
import com.usuario.usuario_ms.model.Usuario;

public class UsuarioMapper {

    public static Usuario requestToModel(UsuarioRequest user) {
        return new Usuario(user);
    }

    public static UsuarioResponse modelToResponse(Usuario user) {
        return new UsuarioResponse(user);
    }
}
