package com.diyara.firstjobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId,Review reviews);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review reviews);

    boolean deleteReview(Long companyId, Long reviewId);
}
