package com.app.application.service;

import java.util.List;
import java.util.stream.Collectors;

import com.app.application.dto.ApiResponse;
import com.app.application.mapper.OrderMapper;
import com.app.domain.enums.EOrderStatus;
import com.app.domain.enums.EStatusStock;
import com.app.domain.models.*;
import com.app.domain.usecase.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.application.dto.OrderDTO;
import com.app.application.dto.OrderItemDTO;
import com.app.application.interfaces.OrderService;
import com.app.infrastructure.exception.BaseException;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDTO> implements OrderService {
    private final OrderUseCase orderUseCase;
    private final ProductUseCase productUseCase;
    private final StockUseCase stockUseCase;
    private final ProductOptionUseCase productOptionUseCase;
    private final OptionChoiceUseCase optionChoiceUseCase;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(
            OrderUseCase orderUseCase,
            OrderMapper orderMapper,
            ProductUseCase productUseCase,
            StockUseCase stockUseCase,
            ProductOptionUseCase productOptionUseCase,
            OptionChoiceUseCase optionChoiceUseCase
    ) {
        super(orderUseCase, orderMapper, Order.class);
        this.orderUseCase = orderUseCase;
        this.productUseCase = productUseCase;
        this.stockUseCase = stockUseCase;
        this.productOptionUseCase = productOptionUseCase;
        this.optionChoiceUseCase = optionChoiceUseCase;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public void createOrder(OrderDTO orderRequest) {
        Order order = prepareOrder(orderRequest);
        List<String> productIds = getProductIdsFromOrderItems(orderRequest);
        List<Product> products = productUseCase.findAllById(productIds);
        Order savedOrder = orderUseCase.save(order);
        processOrderItemsAndStocks(savedOrder, products, orderRequest.getOrderItems());
    }

    private Order prepareOrder(OrderDTO orderRequest) {
        return new Order(orderRequest.getTotalAmount(), EOrderStatus.PENDING);
    }

    private List<String> getProductIdsFromOrderItems(OrderDTO orderRequest) {
        return orderRequest.getOrderItems().stream()
                .map(e -> e.getProduct().getId())
                .collect(Collectors.toList());
    }

    private void processOrderItemsAndStocks(Order order, List<Product> products, List<OrderItemDTO> orderItems) {
        products.forEach(product -> {
            OrderItemDTO orderItem = getOrderItemForProduct(orderItems, product.getId());
            processOrderItemAndStock(order, product, orderItem);
        });
    }

    private OrderItemDTO getOrderItemForProduct(List<OrderItemDTO> orderItems, String productId) {
        return orderItems.stream()
                .filter(e -> e.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new BaseException("Order item not found", HttpStatus.BAD_REQUEST));
    }

    private void processOrderItemAndStock(Order order, Product product, OrderItemDTO orderItemDto) {
        Integer qty = orderItemDto.getQuantity();
        if (qty != null) {
            OrderItem savedOrderItem = createOrderItem(new OrderItem(order, product, qty));

            orderItemDto.getOrderItemOptions().forEach(orderItemOptionDto -> {
                OrderItemOption orderItemOption = new OrderItemOption();
                orderItemOption.setOrderItem(savedOrderItem);

                // Get ProductOption
                ProductOption productOption = productOptionUseCase.findById(orderItemOptionDto.getProductOption().getId())
                        .orElseThrow(() -> new BaseException("ProductOption is null"));
                orderItemOption.setProductOption(productOption);

                OrderItemOption savedOrderItemOption = orderUseCase.createOrderItemOption(orderItemOption);

                // Prepare ids choices
                List<String> choicesIds = orderItemOptionDto.getOrderItemOptionChoice().stream()
                        .map(e -> e.getId())
                        .collect(Collectors.toList());

                // Get all choices
                optionChoiceUseCase.findAllById(choicesIds).forEach(choice -> {
                    OrderItemOptionChoice orderItemOptionChoice = new OrderItemOptionChoice(savedOrderItemOption, choice);
                    orderUseCase.createOrderItemOptionChoice(orderItemOptionChoice);
                });
            });

            updateStock(product, qty);
        }
    }

    private OrderItem createOrderItem(OrderItem orderItem) {
        return orderUseCase.createOrderItem(orderItem);
    }

    private void updateStock(Product product, Integer qty) {
        Stock stock = product.getStock();
        int stockQty = stock.getQuantity();

        if (stockQty < qty) {
            throw new BaseException("Not enough stock", HttpStatus.BAD_REQUEST);
        }

        stock.setQuantity(stockQty - qty);
        stock.setStatus(determineStockStatus(stockQty - qty));
        stock.setProduct(product);
        stockUseCase.save(stock);
    }

    private EStatusStock determineStockStatus(int remainingStock) {
        if (remainingStock == 0) {
            return EStatusStock.OUT_OF_STOCK;
        } else if (remainingStock <= 5) {
            return EStatusStock.LOW_STOCK;
        }
        return EStatusStock.IN_STOCK;
    }

    @Override
    @JsonView(OrderDTO.BasicView.class)
    public ApiResponse<List<OrderDTO>> getAll() {
        List<Order> orders = orderUseCase.findAll();
        return new ApiResponse<>(orders.stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList()));
    }
}
