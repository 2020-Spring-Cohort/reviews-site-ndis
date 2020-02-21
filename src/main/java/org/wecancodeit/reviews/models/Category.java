package org.wecancodeit.reviews.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {


    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String name;
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

    public String getName() {
        return name;
    }


    public Category(String brand, String name) {

        this.brand = brand;
        this.name = name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(brand, category.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand);
    }


    public Collection<Laptop> getLaptops(){
        return laptops;
    }
}