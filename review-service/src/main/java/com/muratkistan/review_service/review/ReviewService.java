package com.muratkistan.review_service.review;

import com.muratkistan.review_service.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReviewService {

    private  final  ReviewRepository reviewRepository;
    private final ReviewMapper revieweMapper;




    public Review saveReview(ReviewRequest request){
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
