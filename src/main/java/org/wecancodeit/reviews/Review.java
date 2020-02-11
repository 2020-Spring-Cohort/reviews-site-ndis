package org.wecancodeit.reviews;

public class Review {
    String laptopName;
    String laptopBrand;
//    String hashtag;


    public Review(String laptopName, String laptopBrand) {
        this.laptopName = laptopName;
        this.laptopBrand = laptopBrand;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public String getLaptopBrand() {
        return laptopBrand;
    }
}
