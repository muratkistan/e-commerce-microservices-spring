package com.muratkistan.review_service.review;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ReviewRequest(

    @NotNull(message = "Name is required")
    String productId,

    @NotNull(message = "Name is required")
    String customerId,

    @Positive(message = "Price should be positive")
    @NotNull(message = "Name is required")
     int rating,

    @NotNull(message = "Name is required")
    String content){
}
