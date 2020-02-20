package org.wecancodeit.reviews.models;

import javax.persistence.*;

import java.util.Objects;

@Entity

public class Laptop {
    @Id
    @GeneratedValue
    private Long id;



    @ManyToOne
    private Categories categories;
    private String brand;
    private String name;
    private String model;



    public Laptop(Categories categories, String brand, String name, String model) {
        this.brand = brand;
        this.name = name;
        this.model = model;
        this.categories = categories;
    }


    public Laptop() {
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Categories getCategories() {
        return categories;
    }

    public Long getId() { return id; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(name, laptop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


