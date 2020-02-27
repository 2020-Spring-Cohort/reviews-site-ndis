package org.wecancodeit.reviews.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private Laptop laptop;

    public Review() {
    }

    public Review(String laptopName, String hashTag, String reviewText, String laptopModel, Laptop laptop) {
        this.laptopName = laptopName;
        this.hashTag = hashTag;
        this.reviewText = reviewText;
        this.laptopModel = laptopModel;
        this.laptop = laptop;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != null ? !id.equals(review.id) : review.id != null) return false;
        if (laptopName != null ? !laptopName.equals(review.laptopName) : review.laptopName != null) return false;
        if (reviewText != null ? !reviewText.equals(review.reviewText) : review.reviewText != null) return false;
        if (hashTag != null ? !hashTag.equals(review.hashTag) : review.hashTag != null) return false;
        if (laptopModel != null ? !laptopModel.equals(review.laptopModel) : review.laptopModel != null) return false;
        return laptop != null ? laptop.equals(review.laptop) : review.laptop == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (laptopName != null ? laptopName.hashCode() : 0);
        result = 31 * result + (reviewText != null ? reviewText.hashCode() : 0);
        result = 31 * result + (hashTag != null ? hashTag.hashCode() : 0);
        result = 31 * result + (laptopModel != null ? laptopModel.hashCode() : 0);
        result = 31 * result + (laptop != null ? laptop.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", laptopName='" + laptopName + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", hashTag='" + hashTag + '\'' +
                ", laptopModel='" + laptopModel + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}