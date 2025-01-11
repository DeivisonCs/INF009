package com.produto.produto_ms.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException (String message) {
        super(message);
    }
    public NotFoundException () {
        super("Resgistro não encontrado");
    }
}
