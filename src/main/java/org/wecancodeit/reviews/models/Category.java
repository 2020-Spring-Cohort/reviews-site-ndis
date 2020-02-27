package org.wecancodeit.reviews.models;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Category {


    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    @OneToMany(mappedBy = "category")
    private Collection<Laptop> laptops;


    public Category(String brand) {
        this.brand = brand;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        return brand != null ? brand.equals(category.brand) : category.brand == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        return result;
    }

    public Collection<Laptop> getLaptops() {
        return laptops;
    }
}