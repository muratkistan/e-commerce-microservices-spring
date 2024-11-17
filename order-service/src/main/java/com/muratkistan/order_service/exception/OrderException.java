package com.muratkistan.order_service.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderException extends RuntimeException {

    private final String msg;
}
