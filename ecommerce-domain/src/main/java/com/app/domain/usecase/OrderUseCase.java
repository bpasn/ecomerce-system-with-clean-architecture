package com.app.domain.usecase;

import com.app.domain.models.Order;
import com.app.domain.models.OrderItem;

public interface OrderUseCase extends BaseUseCase<Order>{
    void createOrderItem(OrderItem orderItem);
}
