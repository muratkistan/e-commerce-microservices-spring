package com.muratkistan.review_service.review;

public record ReviewResponse(
        String id,
         String productId,
         String customerId,
         int rating,
         String content
        ) {
}
