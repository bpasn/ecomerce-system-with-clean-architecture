package com.app.ecommerce.api.controllers.admin;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.CategoriesDTO;
import com.app.application.dto.OrderDTO;
import com.app.application.interfaces.OrderService;
import com.app.domain.models.Order;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix.route}/admin/order")
@Tag(name = "Order Management",description = "Manage order for admin")
public class AdminOrderController {

    private final OrderService orderService;
    public AdminOrderController(OrderService orderService){
        this.orderService = orderService;
    }

//    @GetMapping
//    public ResponseEntity<ApiResponse<List<OrderDTO>>> get(){
//        return ResponseEntity.ok(orderService.getAll());
//    }
@GetMapping
public ResponseEntity<ApiResponse<List<OrderDTO>>> getOrders() {
    return ResponseEntity.ok(orderService.getAll());
}

}
