package com.pk.rentflat.converter.reviews;

import com.pk.rentflat.controller.dto.reviews.ReviewsResponse;
import com.pk.rentflat.model.Reviews;

import java.util.List;

public class ReviewsConverter {

    private ReviewsConverter() {
    }

    public static ReviewsResponse convertReviewToReviewResponse(Reviews reviews) {
        ReviewsResponse reviewsResponse = new ReviewsResponse();
        reviewsResponse.setId(reviews.getId());
        reviewsResponse.setContent(reviews.getContent());
        reviewsResponse.setGrade(reviews.getGrade());
        reviewsResponse.setTitle(reviews.getTitle());
        reviewsResponse.setOfferId(reviewsResponse.getOfferId());
        return reviewsResponse;
    }

    public static List<ReviewsResponse> convertReviewsListToReviewsResponseList(List<Reviews> reviews) {
        return reviews.stream()
                .map(ReviewsConverter::convertReviewToReviewResponse)
                .toList();
    }

}
