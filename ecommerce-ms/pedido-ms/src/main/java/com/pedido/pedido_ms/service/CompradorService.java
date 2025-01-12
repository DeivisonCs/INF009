package com.pedido.pedido_ms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pedido.pedido_ms.dto.request.CompradorRequest;
import com.pedido.pedido_ms.mapper.CompradorMapper;
import com.pedido.pedido_ms.model.Comprador;
import com.pedido.pedido_ms.repository.CompradorRepository;

@Service
public class CompradorService {

    private final CompradorRepository compradorRepository;

    public CompradorService(CompradorRepository compradorRepository){
        this.compradorRepository = compradorRepository;
    }

    private Comprador registerBuyer(CompradorRequest buyerToRegister){
        Comprador buyer = CompradorMapper.requestToModel(buyerToRegister);

        this.compradorRepository.save(buyer);
        return buyer;
    }

    public Comprador getBuyerByCPF(CompradorRequest buyerToGet){
        Optional<Comprador> buyer = this.compradorRepository.findByCpf(buyerToGet.getCpf());

        if(!buyer.isPresent()){
            return this.registerBuyer(buyerToGet);
        }

        return buyer.get();
    }
}
