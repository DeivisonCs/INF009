package com.library.library.service.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.library.library.model.Usuario;

@Service
public class JwtTokenService {

    public String generateToken(Usuario user){
        try{
            var algorithm = Algorithm.HMAC256("secret");

            return JWT.create()
                .withIssuer("My Library")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(this.validTime())
                .sign(algorithm);
        }catch(JWTCreationException ex){
            throw new RuntimeException("Não foi possível gerar o token", ex);
        }
    }

    private Instant validTime(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }


    public String validToken(String token){
        try{
            var algorithm = Algorithm.HMAC256("secret");

            return JWT.require(algorithm)
                .withIssuer("My Library")
                .build()
                .verify(token)
                .getSubject();
        }catch(JWTVerificationException ex){
            throw new RuntimeException("Token inválido ou expirado");
        }
    }
}
