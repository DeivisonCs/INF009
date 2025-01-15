package com.pedido.pedido_ms.dto.response;

import com.pedido.pedido_ms.model.Status;

public class StatusResponse {
    private Long id;
    private String name;

    public StatusResponse(Status status){
        this.id = status.getId();
        this.name = status.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
 
}
