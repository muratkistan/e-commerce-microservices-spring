package com.muratkistan.review_service.review;

import org.springframework.stereotype.Service;

@Service
public class ReviewMapper {

    public Review toReview(ReviewRequest request) {
        return Review.builder()
                .productId(request.productId())
                .customerId(request.customerId())
                .rating(request.rating())
                .content(request.content())
                .build();
    }


    public ReviewResponse toReviewResponse(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getProductId(),
                review.getCustomerId(),
                review.getRating(),
                review.getContent()
        );
    }

}
