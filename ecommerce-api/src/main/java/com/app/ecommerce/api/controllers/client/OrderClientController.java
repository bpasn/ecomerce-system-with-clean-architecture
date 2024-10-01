package com.app.ecommerce.api.controllers.client;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.dto.OrderDTO;
import com.app.application.dto.OrderItemDTO;
import com.app.application.dto.OrderItemObject;
import com.app.application.dto.OrderRequest;
import com.app.application.dto.ProductsDTO;
import com.app.application.interfaces.OrderService;
import com.app.application.interfaces.ProductService;

@RestController
@RequestMapping("${api.prefix.client}/order")
public class OrderClientController {

    private final OrderService orderService;
    private final ProductService productService;

    public OrderClientController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest);
        return ResponseEntity.ok("Order has been created!");
    }

}
