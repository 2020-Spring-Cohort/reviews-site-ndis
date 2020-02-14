package org.wecancodeit.reviews;
import java.util.Objects;


public class Categories {
    private String brand;
    private String name;
    private String modelNumber;

    public String getName() {
        return name;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public Categories(String brand, String name, String modelNumber){

        this.brand = brand;
        this.name = name;
        this.modelNumber = modelNumber;
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