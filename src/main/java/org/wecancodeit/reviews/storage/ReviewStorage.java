package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Review;

import java.util.Collection;

public interface ReviewStorage {

    void store(Review review);

    Review findReviewById(long id);
}
