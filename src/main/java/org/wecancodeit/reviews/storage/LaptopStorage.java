package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Laptop;

import java.util.Collection;

public interface LaptopStorage {
    Collection<Laptop> findAllLaptops();

    void store(Laptop laptop);
    Laptop findLaptopByName (String laptopName);
}
