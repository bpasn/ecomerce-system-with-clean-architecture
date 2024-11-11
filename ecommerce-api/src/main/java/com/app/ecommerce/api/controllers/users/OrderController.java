package com.app.ecommerce.api.controllers.users;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("${api.prefix.route}/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
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
        ApiResponse<List<OrderDTO>> response = orderService.getAll();
        return ResponseEntity.ok(response);
    }


    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<OrderDTO>> getOrderById(@PathVariable String id){
        return ResponseEntity.ok(orderService.getById(id));
    }
}
