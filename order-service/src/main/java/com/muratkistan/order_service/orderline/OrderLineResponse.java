package com.muratkistan.order_service.orderline;

public record OrderLineResponse(
        Integer id,
        double quantity
) { }