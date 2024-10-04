package com.app.domain.usecase;

import com.app.domain.models.Order;
import com.app.domain.models.OrderItem;
import com.app.domain.models.OrderItemOption;
import com.app.domain.models.OrderItemOptionChoice;

public interface OrderUseCase extends BaseUseCase<Order>{
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItemOption createOrderItemOption(OrderItemOption orderItemoption);
    OrderItemOptionChoice createOrderItemOptionChoice(OrderItemOptionChoice orderItemOptionChoice);
}
