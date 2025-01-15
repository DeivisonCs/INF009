package com.pedido.pedido_ms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pedido.pedido_ms.dto.enums.OrderStatus;
import com.pedido.pedido_ms.dto.response.StatusResponse;
import com.pedido.pedido_ms.model.Status;
import com.pedido.pedido_ms.repository.StatusRepository;

@Service
public class StatusService {

    private final StatusRepository statusRespository;

    public StatusService (StatusRepository statusRespository){
        this.statusRespository = statusRespository;
    }

    public List<StatusResponse> getStatus(){
        List<Status> status = this.statusRespository.findAll();

        return status.stream().map(StatusResponse::new).toList();
    }

    public Status getStatus(OrderStatus status){
        return this.statusRespository.findByName(status.name());
    }
}
