package com.muratkistan.order_service.payment;

import com.muratkistan.order_service.customer.CustomerResponse;
import com.muratkistan.order_service.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}

