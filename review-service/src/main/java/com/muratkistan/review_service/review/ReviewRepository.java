package com.muratkistan.review_service.review;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository  extends ElasticsearchRepository<Review, String> {
    @Query("{\"match\": {\"content\": \"?0\"}}")
    List<Review> findByContent(String keyword);

    @Query("{\"term\": {\"productId\": \"?0\"}}")
    List<Review> findByProductId(String productId);
}
