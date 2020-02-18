package org.wecancodeit.reviews;

public class Review {
    String laptopName;
    String laptopBrand;
    String reviewText;
    String hashTag;
    String laptopModel;

    public Review  (String laptopName, String laptopBrand, String hashTag, String reviewText, String laptopModel) {
        this.laptopName = laptopName;
        this.laptopBrand = laptopBrand;
        this.hashTag = hashTag;
        this.reviewText = reviewText;
        this.laptopModel = laptopModel;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public String getLaptopBrand() {
        return laptopBrand;

    }
    public String getLaptopModel() {
        return laptopModel;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getHashTag() {
        return hashTag;
    }

}