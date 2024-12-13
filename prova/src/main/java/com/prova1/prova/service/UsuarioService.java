package com.prova1.prova.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prova1.prova.dto.request.UsuarioRequest;
import com.prova1.prova.mapper.UsuarioMapper;
import com.prova1.prova.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder encoder){
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }

    public void create(UsuarioRequest user){
        user.setPassword(this.encoder.encode(user.getPassword()));

        this.usuarioRepository.save(UsuarioMapper.requestToModel(user));
    }
}
