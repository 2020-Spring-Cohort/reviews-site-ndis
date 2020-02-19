package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Categories {


    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String name;
    @OneToMany(mappedBy = "categories")
    public Collection<Laptop> laptops;


    public Categories(String brand) {
        this.brand = brand;
    }

    public Categories() {
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


    public Categories(String brand, String name) {

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

    public Collection<Laptop> getLaptops() {
        return laptops;
    }
}