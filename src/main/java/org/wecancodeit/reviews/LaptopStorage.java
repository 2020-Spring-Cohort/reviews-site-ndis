package org.wecancodeit.reviews;

import java.util.Collection;

public interface LaptopStorage {
    Collection<Laptop> findAllLaptops();

    void store(Laptop laptop);
    Laptop findLaptopByName (String laptopName);
}
