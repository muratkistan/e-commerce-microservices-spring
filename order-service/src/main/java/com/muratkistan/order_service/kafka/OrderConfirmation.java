package com.muratkistan.order_service.kafka;

import com.muratkistan.order_service.customer.CustomerResponse;
import com.muratkistan.order_service.order.PaymentMethod;
import com.muratkistan.order_service.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}

