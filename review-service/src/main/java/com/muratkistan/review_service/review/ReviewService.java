package com.muratkistan.review_service.review;

import com.muratkistan.review_service.client.CustomerClient;
import com.muratkistan.review_service.client.ProductClient;
import com.muratkistan.review_service.exception.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReviewService {

    private  final  ReviewRepository reviewRepository;
    private final ReviewMapper revieweMapper;
    private final ProductClient productClient;
    private final CustomerClient customerClient;




    public Review saveReview(@Valid @RequestBody ReviewRequest request){
        boolean customerIsExist = this.customerClient.existsById(request.customerId());
        boolean productIsExist = this.productClient.existsById(request.productId());
        if (!customerIsExist ) {
            throw new EntityNotFoundException("Customer not found with id: " + request.customerId());
        }
        if (!productIsExist) {
            throw new EntityNotFoundException("Product not found with id: " + request.productId());
        }

        var review = revieweMapper.toReview(request);
        return reviewRepository.save(review);
    }

    public ReviewResponse getReviewById(String id){
        return reviewRepository.findById(id).map(review -> revieweMapper.toReviewResponse(review)).orElseThrow(() -> new EntityNotFoundException("Review not found with id: " + id));
    }

    public void deleteReviewById(String id){
        reviewRepository.deleteById(id);
    }

    public Page<ReviewResponse> getAllReviews(Pageable pageable) {
        List<ReviewResponse> reviews = reviewRepository.findAll(pageable)
                .stream()
                .map(review -> revieweMapper.toReviewResponse(review))
                .collect(Collectors.toList());
        return new PageImpl<>(reviews, pageable, reviews.size());
    }

    public List<ReviewResponse> searchReviewsByContent(String keyword) {
        return reviewRepository.findByContent(keyword)
                .stream()
                .map(review -> revieweMapper.toReviewResponse(review))
                .collect(Collectors.toList());
    }

    public List<ReviewResponse> getReviewsByProductId(String productId) {
        return reviewRepository.findByProductId(productId)
                .stream()
                .map(review -> revieweMapper.toReviewResponse(review))
                .collect(Collectors.toList());
    }


}
