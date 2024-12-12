package br.edu.ifba.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.blog.dtos.DadosAutenticacao;
import br.edu.ifba.blog.dtos.DadosTokenJWT;
import br.edu.ifba.blog.entities.Usuario;
import br.edu.ifba.blog.services.JWTokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	 @Autowired
     private AuthenticationManager manager;
	 @Autowired
	 private JWTokenService tokenService;
	
	@PostMapping
    public ResponseEntity efetuarLogin(@RequestBody  DadosAutenticacao dados) {
		var dtoAuth=new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var authentication = manager.authenticate(dtoAuth);
		Usuario usuario = (Usuario) authentication.getPrincipal();
		DadosTokenJWT token = new DadosTokenJWT(tokenService.gerarToken(usuario));
		return ResponseEntity.ok(token);
    }

}
