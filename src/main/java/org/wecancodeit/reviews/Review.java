package org.wecancodeit.reviews;

public class Review {
    String laptopName;
    String laptopBrand;
    String reviewText;
    String hashTag;


    public Review  (String laptopName, String laptopBrand, String hashTag, String reviewText) {
        this.laptopName = laptopName;
        this.laptopBrand = laptopBrand;
        this.hashTag = hashTag;
        this.reviewText = reviewText;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public String getLaptopBrand() {
        return laptopBrand;

    }

    public String getReviewText() {
        return reviewText;
    }

    public String getHashTag() {
        return hashTag;
    }

}