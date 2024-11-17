package com.muratkistan.payment_service.payment;

import com.muratkistan.payment_service.notification.NotificationProducer;
import com.muratkistan.payment_service.notification.PaymentNotificationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final ModelMapper modelMapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = this.repository.save(this.modelMapper.map(request,Payment.class));

        this.notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No payment found with the provided ID: " + id));
    }

    @Override
    public void deletePayment(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("No order line found with the provided ID: " + id);
        }
    }
}
