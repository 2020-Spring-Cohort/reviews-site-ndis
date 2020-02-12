package org.wecancodeit.reviews;

import java.util.Objects;

public class Categories {
    private String brand;

    public Categories(String brand){

        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories categories = (Categories) o;
        return Objects.equals(brand, categories.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand);
    }
}