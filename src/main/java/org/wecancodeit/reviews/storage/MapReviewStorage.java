package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Review;

import java.util.Collection;
import java.util.HashMap;

@Service
public class MapReviewStorage implements ReviewStorage {
    private HashMap<String, Review> reviewList;

    public MapReviewStorage(){reviewList = new HashMap<>();}

    @Override
    public Collection<Review> findAllReviews(){return reviewList.values();}

    @Override
    public void store(Review review){reviewList.put(review.getLaptopName(), review);}

    @Override
    public Review findReviewByLaptopName(String reviewLaptopName){
        return reviewList.get(reviewLaptopName);
    }
}
