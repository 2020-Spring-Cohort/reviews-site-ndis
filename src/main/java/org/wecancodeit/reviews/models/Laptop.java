package org.wecancodeit.reviews.models;

import javax.persistence.*;

import java.util.Collection;

@Entity

public class Laptop {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    private Category category;
    private String name;
    private String model;

    @OneToMany(mappedBy = "laptop")
    private Collection<Review> reviews;


    public Laptop(Category category, String name, String model) {

        this.model = model;
        this.category = category;
        this.name = name;

    }


    public Laptop() {
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Category getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (id != null ? !id.equals(laptop.id) : laptop.id != null) return false;
        if (category != null ? !category.equals(laptop.category) : laptop.category != null) return false;
        if (name != null ? !name.equals(laptop.name) : laptop.name != null) return false;
        return model != null ? model.equals(laptop.model) : laptop.model == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}




