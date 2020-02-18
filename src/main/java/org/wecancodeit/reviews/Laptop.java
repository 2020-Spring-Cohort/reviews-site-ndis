package org.wecancodeit.reviews;

import java.util.Objects;

public class Laptop {
    private String brand;
    private String name;
    private String model;

    public String getBrand() {

        return brand;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public Laptop(String brand, String name, String model) {
        this.brand = brand;
        this.name = name;
        this.model = model;
    }

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


