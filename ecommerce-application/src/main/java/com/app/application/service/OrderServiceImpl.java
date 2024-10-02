package com.app.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.domain.models.*;
import com.app.infrastructure.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.application.dto.OrderDTO;
import com.app.application.dto.OrderItemObject;
import com.app.application.dto.OrderRequest;
import com.app.application.interfaces.OrderService;
import com.app.application.interfaces.StockService;
import com.app.application.mapper.OrderMapper;
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
        Order order = prepareOrder(orderRequest);

        Map<String, Integer> productIdToQuantityMap = getProductQuantityMap(orderRequest);

        List<Product> products = productUseCase.findAllById(new ArrayList<>(productIdToQuantityMap.keySet()));

        Order savedOrder = orderUseCase.save(order);

        products.forEach(product -> processOrderItemAndStock(savedOrder, product, productIdToQuantityMap));
    }

    private Order prepareOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setOrderStatus(EOrderStatus.PENDING);
        return order;
    }

    private Map<String, Integer> getProductQuantityMap(OrderRequest orderRequest) {
        return orderRequest.getOrderItems().stream()
                .collect(Collectors.toMap(OrderItemObject::getProductId, OrderItemObject::getQuantity));
    }

    private void processOrderItemAndStock(Order order, Product product, Map<String, Integer> productIdToQuantityMap) {
        String productId = product.getId();
        Integer qty = productIdToQuantityMap.get(productId);

        if (qty != null) {
            createOrderItem(order, product, qty);
            updateStock(product, qty);
        }
    }

    private void createOrderItem(Order order, Product product, Integer qty) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(qty);
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderUseCase.createOrderItem(orderItem);
    }

    private void updateStock(Product product, Integer qty) {
        Stock stock = product.getStock();
        int stockQty = stock.getQuantity();

        if (stockQty - qty < 0) {
            throw new BaseException("Not enough of stock", HttpStatus.BAD_REQUEST);
        }
        stock.setQuantity(stockQty - qty);
        stock.setStatus(determineStockStatus(stockQty, qty));
        product.setStock(null);
        stock.setProduct(product);
        stockUseCase.save(stock);
    }

    private EStatusStock determineStockStatus(int stockQty, int qty) {
        if (stockQty - qty == 0) {
            return EStatusStock.OUT_OF_STOCK;
        } else if (stockQty - qty <= 5) {
            return EStatusStock.LOW_STOCK;
        }
        return EStatusStock.IN_STOCK;
    }

}
