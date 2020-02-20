package org.wecancodeit.reviews.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String laptopName;
    private String reviewText;
    private String hashTag;
    private String laptopModel;
    @ManyToOne
    private Categories categories;

    public Review(){}

    public Review(String laptopName, Categories categories, String hashTag, String reviewText, String laptopModel) {
        this.laptopName = laptopName;
        this.hashTag = hashTag;
        this.reviewText = reviewText;
        this.laptopModel = laptopModel;
        this.categories = categories;
    }

    public String getLaptopName() {
        return laptopName;
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

    public Categories getCategories(){
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) &&
                Objects.equals(laptopName, review.laptopName) &&
                Objects.equals(reviewText, review.reviewText) &&
                Objects.equals(hashTag, review.hashTag) &&
                Objects.equals(laptopModel, review.laptopModel) &&
                Objects.equals(categories, review.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, laptopName, reviewText, hashTag, laptopModel, categories);
    }
}