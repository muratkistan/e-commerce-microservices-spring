package com.muratkistan.review_service.exception;

import lombok.Data;

@Data
public class EntityNotFoundException extends RuntimeException {

    private final  String message;

}
