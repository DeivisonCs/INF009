package com.usuario.usuario_ms.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(){
        super("Resgistro não encontrado");
    }
}
