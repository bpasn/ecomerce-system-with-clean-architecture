package com.app.ecommerce.api.controllers.client;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.application.dto.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderDTO>>> getOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }

}
