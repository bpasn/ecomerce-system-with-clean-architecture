package com.app.ecommerce.api.controllers.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.OrderDTO;
import com.app.application.dto.OrderItemDTO;
import com.app.application.dto.OrderItemOptionChoiceDTO;
import com.app.application.dto.OrderItemOptionDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.OrderService;
import com.app.ecommerce.api.request.order.OrderRequest;

@RestController
@RequestMapping("${api.prefix.client}/order")
public class OrderClientController {

    private final OrderService orderService;

    public OrderClientController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setTotalAmount(orderRequest.getTotalAmount());
        orderDTO.setOrderStatus(orderRequest.getOrderStatus());
        orderRequest.getOrderItems().stream().forEach(e -> {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setQuantity(e.getQuantity());
            orderItemDTO.setProduct(new ProductsDTO(e.getProductId()));
            e.getOptions().stream().forEach(o -> {
                OrderItemOptionDTO orderItemOption = new OrderItemOptionDTO();
                orderItemOption.setProductOption(new ProductOptionDTO(o.getId()));
                o.getChoices().stream().forEach(c -> {
                    orderItemOption.getOrderItemOptionChoice().add(new OrderItemOptionChoiceDTO(c));
                });
                orderItemDTO.getOrderItemOptions().add(orderItemOption);
            });
            orderDTO.getOrderItems().add(orderItemDTO);
        });
         orderService.createOrder(orderDTO);
        return ResponseEntity.ok("Order has been created!");
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderDTO>>> getOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

}
