package com.muratkistan.order_service.order;

import java.util.List;

public interface OrderService {
    Integer createOrder(OrderRequest request);
    List<OrderResponse> findAllOrders();
    OrderResponse findById(Integer id);
}
