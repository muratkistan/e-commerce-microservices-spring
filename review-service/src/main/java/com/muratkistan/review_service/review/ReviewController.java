package com.muratkistan.review_service.review;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private  final  ReviewService reviewService;

    @GetMapping
    Page<ReviewResponse> getAllReviews(Pageable pageable){
        var allReviews =  reviewService.getAllReviews(pageable);
        return allReviews;

    }

    @PostMapping
    public Review saveReview(@RequestBody ReviewRequest request){
        return reviewService.saveReview(request);
    }

    @GetMapping("/search")
    public List<ReviewResponse> searchReviewsByContent(@RequestParam String keyword) {
        return reviewService.searchReviewsByContent(keyword);
    }

    @GetMapping("/product/{productId}")
    public List<ReviewResponse> getReviewsByProductId(@PathVariable String productId) {
        return reviewService.getReviewsByProductId(productId);
    }

}
