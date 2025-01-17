package com.pedido.pedido_ms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pedido.pedido_ms.client.usuarioMs.UsuarioClient;
import com.pedido.pedido_ms.client.usuarioMs.UsuarioClientResponse;
import com.pedido.pedido_ms.exception.NotFoundException;
import com.pedido.pedido_ms.model.Comprador;
import com.pedido.pedido_ms.repository.CompradorRepository;

@Service
public class CompradorService {

    private final CompradorRepository compradorRepository;
    private final UsuarioClient usuarioClient;

    public CompradorService(CompradorRepository compradorRepository, UsuarioClient usuarioClient){
        this.compradorRepository = compradorRepository;
        this.usuarioClient = usuarioClient;
    }

    private Comprador registerBuyer(String cpf){
        UsuarioClientResponse user = this.usuarioClient.getUserByCpf(cpf);

        if(user == null){
            throw new NotFoundException("Não foi possível recuperar dados do usuário");
        }

        Comprador buyer = new Comprador(user);
        this.compradorRepository.save(buyer);

        return buyer;
    }

    public Comprador getBuyerByCPF(String cpf){
        Optional<Comprador> buyer = this.compradorRepository.findByCpf(cpf);

        if(!buyer.isPresent()){
            return this.registerBuyer(cpf);
        }

        return buyer.get();
    }
}
