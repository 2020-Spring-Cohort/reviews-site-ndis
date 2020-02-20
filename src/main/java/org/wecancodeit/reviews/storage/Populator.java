package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Categories;
import org.wecancodeit.reviews.models.Laptop;
import org.wecancodeit.reviews.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorageJpaImpl categoryStorageJpaImpl;
    private LaptopStorage laptopStorage;
    private ReviewStorage reviewStorage;



    public Populator(CategoryStorageJpaImpl categoryStorageJpaImpl, LaptopStorage laptopStorage, ReviewStorage reviewStorage) {
        this.categoryStorageJpaImpl = categoryStorageJpaImpl;
        this.laptopStorage = laptopStorage;
        this.reviewStorage = reviewStorage;
    }
        @Override
    public void run (String... args) throws Exception {


            categoryStorageJpaImpl.store(new Categories("HP","akdjsfnka"));
            categoryStorageJpaImpl.store(new Categories("AlienWare","fnasjdnfasn"));
            categoryStorageJpaImpl.store(new Categories("Dell","fdgdg"));
            categoryStorageJpaImpl.store(new Categories("MSI","asdfaf"));

            Laptop msi1 = new Laptop();
            laptopStorage.store(msi1);
            Laptop msi2 = new Laptop();
            laptopStorage.store(msi2);
            Laptop msi3 = new Laptop();
            laptopStorage.store(msi3);
            Laptop msi4 = new Laptop();
            laptopStorage.store(msi4);

            Laptop alien1 = new Laptop();
            laptopStorage.store(alien1);
            Laptop alien2 = new Laptop();
            laptopStorage.store(alien2);
            Laptop alien3 = new Laptop();
            laptopStorage.store(alien3);
            Laptop alien4 = new Laptop();
            laptopStorage.store(alien4);

            Laptop hp1 = new Laptop();
            laptopStorage.store(hp1);
            Laptop hp2 = new Laptop();
            laptopStorage.store(hp2);
            Laptop hp3 = new Laptop();
            laptopStorage.store(hp3);
            Laptop hp4 = new Laptop();
            laptopStorage.store(hp4);

            Laptop lenovo1 = new Laptop();
            laptopStorage.store(lenovo1);
            Laptop lenovo2 = new Laptop();
            laptopStorage.store(lenovo2);
            Laptop lenovo3 = new Laptop();
            laptopStorage.store(lenovo3);
            Laptop lenovo4 = new Laptop();
            laptopStorage.store(lenovo4);

            Review review1 = new Review();
            reviewStorage.store(review1);

        }
    }
