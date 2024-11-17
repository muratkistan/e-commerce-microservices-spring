package com.muratkistan.payment_service.payment;

public interface PaymentService {
    Integer createPayment(PaymentRequest request);
    Payment getPaymentById(Integer id);
    void deletePayment(Integer id);



}
