package com.muratkistan.review_service.review;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "reviews")
public class Review {

    @Id
    private String id;
    private String productId;
    private String customerId;
    private int rating;
    private String content;
}
