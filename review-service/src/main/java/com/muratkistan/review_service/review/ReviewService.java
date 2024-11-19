package com.muratkistan.review_service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewService {

    private  final  ReviewRepository reviewRepository;
    private final ReviewMapper revieweMapper;




    public Review saveReview(ReviewRequest request){
        var review = revieweMapper.toReview(request);
        return reviewRepository.save(review);
    }

    public Review getReviewById(String id){
        return reviewRepository.findById(id).map(revieweMapper::to orElse(null);
    }

    public void deleteReviewById(String id){
        reviewRepository.deleteById(id);
    }

    public Page<ReviewResponse> getAllReviews(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    public List<Review> searchReviewsByContent(String keyword) {
        return reviewRepository.findByContent(keyword);
    }

    public List<Review> getReviewsByProductId(String productId) {
        return reviewRepository.findByProductId(productId);
    }


}
