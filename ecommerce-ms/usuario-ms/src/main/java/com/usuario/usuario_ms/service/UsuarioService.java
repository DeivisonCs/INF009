package com.usuario.usuario_ms.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.usuario.usuario_ms.dto.request.UsuarioRequest;
import com.usuario.usuario_ms.dto.response.UsuarioResponse;
import com.usuario.usuario_ms.exception.NotFoundException;
import com.usuario.usuario_ms.mapper.UsuarioMapper;
import com.usuario.usuario_ms.model.Usuario;
import com.usuario.usuario_ms.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder){
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }

    public UsuarioResponse register (UsuarioRequest usuario){
        Usuario newUser = UsuarioMapper.requestToModel(usuario);
        newUser.setPassword(this.encoder.encode(usuario.getPassword()));
        
        this.usuarioRepository.save(newUser);

        return UsuarioMapper.modelToResponse(newUser);
    }

    public UsuarioResponse getUserById(Long id){
        Usuario user = this.getById(id);

        if(user == null){
            throw new NotFoundException("Usuário não encontrado");
        }

        return UsuarioMapper.modelToResponse(user);
    }
    
    public UsuarioResponse getUserByCpf(String cpf){
        Usuario user = this.getByCpf(cpf);

        if(user == null){
            throw new NotFoundException("Usuário não encontrado");
        }

        return UsuarioMapper.modelToResponse(user);
    }

    private Usuario getById (Long id){
        Optional<Usuario> op = this.usuarioRepository.findById(id);

        if(op.isPresent()){
            return op.get();
        }

        return null;
    }
    
    private Usuario getByCpf (String cpf){
        Optional<Usuario> op = this.usuarioRepository.findByCpf(cpf);

        if(op.isPresent()){
            return op.get();
        }

        return null;
    }
}
