package com.muratkistan.notification_service.kafka.order;


import com.muratkistan.notification_service.kafka.payment.PaymentMethod;

import java.math.BigDecimal;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products

) {
}

