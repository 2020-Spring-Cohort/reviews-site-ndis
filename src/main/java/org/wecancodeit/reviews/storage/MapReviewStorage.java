package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Review;

import java.util.Collection;
import java.util.HashMap;


public class MapReviewStorage implements ReviewStorage {
    private HashMap<String, Review> reviewList;

    public MapReviewStorage() {
        reviewList = new HashMap<>();
    }


    @Override
    public void store(Review review) {
        reviewList.put("",review);
    }

    @Override
    public Review findReviewById(long id) {
        return reviewList.get(id);
    }
}
