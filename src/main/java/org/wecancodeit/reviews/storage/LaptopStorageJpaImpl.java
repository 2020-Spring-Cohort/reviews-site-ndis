package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Laptop;
import org.wecancodeit.reviews.storage.repos.LaptopRepository;

import java.util.Collection;

@Service
public class LaptopStorageJpaImpl implements LaptopStorage {

    private LaptopRepository laptopRepository;

    public LaptopStorageJpaImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    @Override
    public Collection<Laptop> findAllLaptops() {
        return (Collection<Laptop>) laptopRepository.findAll();
    }

    @Override
    public void store(Laptop laptop) {

        laptopRepository.save(laptop);

    }

    @Override
    public Laptop findLaptopByName(String name) {
        return laptopRepository.findByName(name).get();
    }
}
