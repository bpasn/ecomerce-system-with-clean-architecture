package com.app.application.interfaces;

import com.app.application.dto.OrderDTO;
import com.app.domain.models.Order;

public interface OrderService extends BaseService<Order,OrderDTO> {

    void createOrder(OrderDTO orderRequest);
}
