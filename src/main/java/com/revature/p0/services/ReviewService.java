package com.revature.p0.services;

import java.util.List;

import com.revature.p0.daos.ReviewDAO;
import com.revature.p0.models.Review;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReviewService {
    private final ReviewDAO reviewDAO;

    public List<Review> findReviewByProductId(String productId) {
        return this.reviewDAO.findReviewByProductId(productId);
    }

    /*------------------------------Helper Method---------------------------*/

    public static ReviewService getReviewService() {
        return new ReviewService(new ReviewDAO());
    }
}
