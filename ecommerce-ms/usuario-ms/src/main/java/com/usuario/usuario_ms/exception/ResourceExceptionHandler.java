package com.usuario.usuario_ms.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> NotFoundExceptionHandler (NotFoundException ex, HttpServletRequest request) {
        
        StandardError error = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Registro não encontrado", request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
