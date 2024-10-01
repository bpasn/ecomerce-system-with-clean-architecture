package com.app.application.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.application.dto.OrderDTO;
import com.app.application.dto.OrderItemObject;
import com.app.application.dto.OrderRequest;
import com.app.application.interfaces.OrderService;
import com.app.application.interfaces.StockService;
import com.app.application.mapper.OrderMapper;
import com.app.domain.models.EOrderStatus;
import com.app.domain.models.Order;
import com.app.domain.models.OrderItem;
import com.app.domain.models.Product;
import com.app.domain.models.Stock;
import com.app.domain.usecase.OrderUseCase;
import com.app.domain.usecase.ProductUseCase;
import com.app.domain.usecase.StockUseCase;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDTO> implements OrderService {
    private final OrderUseCase orderUseCase;
    private final ProductUseCase productUseCase;
    private final StockUseCase stockUseCase;

    public OrderServiceImpl(OrderUseCase orderUseCase, OrderMapper baseMapper, ProductUseCase productUseCase,StockUseCase stockUseCase) {
        super(orderUseCase, baseMapper, Order.class);
        this.orderUseCase = orderUseCase;
        this.productUseCase = productUseCase;
        this.stockUseCase = stockUseCase;
    }

    @Override
    @Transactional
    public void createOrder(OrderRequest orderRequest) {
        Order order = new Order();

        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setOrderStatus(EOrderStatus.PENDING);
        // ดึงรายการ productId จาก orderItems
        List<String> productIds = orderRequest.getOrderItems().stream()
                .map(OrderItemObject::getProductId)
                .toList();
        // ดึง Product จาก service
        List<Product> products = productUseCase.findAllById(productIds);

        // จัดกลุ่ม OrderItemObject โดย productId เพื่อให้หาค่า quantity ได้ง่ายขึ้น
        Map<String, Integer> productIdToQuantityMap = orderRequest.getOrderItems().stream()
                .collect(Collectors.toMap(OrderItemObject::getProductId, OrderItemObject::getQuantity));

        
        
        products.forEach(product -> {
            OrderItem orderItem = new OrderItem();
            String productId = product.getId();

            Order orderSave = orderUseCase.save(order);
            // หา quantity ที่ตรงกับ productId ในแผนที่ที่จัดกลุ่มไว้
            Integer qty = productIdToQuantityMap.get(productId);
            if (qty != null) {
                orderItem.setQuantity(qty);
                orderItem.setProduct(product);
                orderItem.setOrder(orderSave);
                order.getOrderItems().add(orderItem);

                Stock stock = new Stock();
                stock.setId(product.getStock().getId());
                stock.setReOrder(product.getStock().isReOrder());
                stock.setStatus(product.getStock().getStatus());
                stock.setUnitQuantity(product.getStock().getUnitQuantity());
                stock.setUnitType(product.getStock().getUnitType());
                stock.setProduct(product);
                stock.setQuantity(product.getStock().getQuantity() - qty);
                stockUseCase.save(stock);
            }
        });

        orderUseCase.save(order);

    }

}
