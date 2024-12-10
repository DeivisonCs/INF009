package com.biblioteca.biblioteca.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.biblioteca.biblioteca.model.Usuario;

@Service
public class JwtTokenService {

    public String gerarToken(Usuario user){
        try{
            var algorithm = Algorithm.HMAC256("secret");

            return JWT.create()
                .withIssuer("My Library")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(tempoExpiracao())
                .sign(algorithm);   
        }catch(JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    private Instant tempoExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256("secret");
            return JWT.require(algoritmo)
            .withIssuer("My Library")
            .build()
            .verify(tokenJWT)
            .getSubject();
        } catch ( JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }
}
