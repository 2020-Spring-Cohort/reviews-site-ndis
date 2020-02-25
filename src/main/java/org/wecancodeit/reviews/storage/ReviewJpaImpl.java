package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.repos.ReviewRepository;

@Service
public class ReviewJpaImpl implements ReviewStorage {
    private ReviewRepository reviewRepository;

    public ReviewJpaImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public void store(Review review) {
        reviewRepository.save(review);

    }

    @Override
    public Review findReviewById(long id) {
        return reviewRepository.findById(id).get();
    }
}
