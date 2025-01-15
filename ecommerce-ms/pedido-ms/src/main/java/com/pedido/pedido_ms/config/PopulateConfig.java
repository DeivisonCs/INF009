package com.pedido.pedido_ms.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.pedido.pedido_ms.dto.enums.OrderStatus;
import com.pedido.pedido_ms.model.Status;
import com.pedido.pedido_ms.repository.StatusRepository;

@Component
public class PopulateConfig {

    @Autowired
    private StatusRepository statusRespository;

    @EventListener(ApplicationReadyEvent.class)
    public void populate() {
        System.out.println("\n ------------ Adding Order Status --------------- \n");
        this.createOrderStatus();
    }

    private void createOrderStatus(){
        List<Status> status = Arrays.asList(
            new Status(OrderStatus.WAITING_PAYMENT.name()),
            new Status(OrderStatus.CANCELED.name()),
            new Status(OrderStatus.PAYMENT_REFUSED.name()),
            new Status(OrderStatus.PAYMENT_APPROVED.name()),
            new Status(OrderStatus.PROCESSING.name()),
            new Status(OrderStatus.IN_TRANSIT.name()),
            new Status(OrderStatus.OUT_FOR_DELIVERY.name()),
            new Status(OrderStatus.DELIVERED.name())
        );

        this.statusRespository.saveAll(status);
    }

}
