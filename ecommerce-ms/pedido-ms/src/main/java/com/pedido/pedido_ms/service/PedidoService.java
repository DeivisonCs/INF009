package com.pedido.pedido_ms.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pedido.pedido_ms.dto.enums.OrderStatus;
import com.pedido.pedido_ms.dto.request.PedidoProdutoRequest;
import com.pedido.pedido_ms.dto.request.PedidoRequest;
import com.pedido.pedido_ms.dto.response.PedidoResponse;
import com.pedido.pedido_ms.mapper.PedidoMapper;
import com.pedido.pedido_ms.model.Comprador;
import com.pedido.pedido_ms.model.Pedido;
import com.pedido.pedido_ms.model.PedidoProduto;
import com.pedido.pedido_ms.model.Produto;
import com.pedido.pedido_ms.model.Status;
import com.pedido.pedido_ms.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final CompradorService compradorService;
    private final StatusService statusService;

    public PedidoService (PedidoRepository pedidoRepository, ProdutoService produtoService, CompradorService compradorService, StatusService statusService){
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.compradorService = compradorService;
        this.statusService = statusService;
    }

    public PedidoResponse registerOrder(PedidoRequest order){
        Comprador buyer = this.compradorService.getBuyerByCPF(order.getBuyerCpf());

        Pedido newOrder = new Pedido();
        newOrder.setBuyer(buyer);
        newOrder.setPrice(order.getPrice());
        newOrder.setStatus(this.statusService.getStatus(OrderStatus.WAITING_PAYMENT));

        Set<PedidoProduto> productOrder = this.getPedidoProduto(order.getProducts(), newOrder);

        newOrder.setProducts(productOrder);

        this.pedidoRepository.save(newOrder);

        return PedidoMapper.modelToResponse(newOrder);
    }

    private Set<PedidoProduto> getPedidoProduto(Set<PedidoProdutoRequest> orderProduct, Pedido order){

        return  orderProduct.stream().map(productResquest -> {
            Produto product = this.produtoService.getProduct(productResquest.getserialNumber());

            if(!this.produtoService.isInStock(product.getSerialNumber())){
                return null;
            }

            PedidoProduto productOrder = new PedidoProduto();
            productOrder.setProduct(product);
            productOrder.setAmount(productResquest.getAmount());
            productOrder.setUnitPrice(productResquest.getUnitPrice());
            productOrder.setOrder(order);

            return productOrder;
        }).collect(Collectors.toSet());
    }

    public List<PedidoResponse> getAllOrders(){
        List<Pedido> orders = this.pedidoRepository.findAll();
        return PedidoMapper.modelListToResponseList(orders);
    }

    public void updateOrderStatus(Long orderId, OrderStatus newStatus){
        Pedido order = this.getById(orderId);

        if (order == null) {
            // tratar exceção
            return;
        }

        Status status = this.statusService.getStatus(newStatus);

        order.setStatus(status);
        this.pedidoRepository.save(order);
    }

    private Pedido getById(Long id){
        Optional<Pedido> op = this.pedidoRepository.findById(id);

        if(!op.isPresent()){
            return null;
        }

        return op.get();
    }
}
