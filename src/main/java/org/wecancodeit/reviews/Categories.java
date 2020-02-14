package org.wecancodeit.reviews;
import java.util.Objects;


public class Categories {
    private String brand;
    private String name;


    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }



    public Categories(String brand, String name){

        this.brand = brand;
        this.name = name;

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
        return Objects.hash(name);
    }
}