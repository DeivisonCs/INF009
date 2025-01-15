package com.pedido.pedido_ms.dto.enums;

public enum OrderStatus {
    WAITING_PAYMENT, 
    CANCELED,
    PAYMENT_REFUSED,
    PAYMENT_APPROVED, 
    PROCESSING,
    IN_TRANSIT,
    OUT_FOR_DELIVERY,
    DELIVERED;
}
