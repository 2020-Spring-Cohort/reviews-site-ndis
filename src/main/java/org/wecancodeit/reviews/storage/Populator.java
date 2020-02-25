package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Category;
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
    public void run (String... args){


            categoryStorageJpaImpl.store(new Category("HP","testName"));
            categoryStorageJpaImpl.store(new Category("AlienWare","testName"));
            categoryStorageJpaImpl.store(new Category("Dell","testName"));
            categoryStorageJpaImpl.store(new Category("MSI","testName"));



            Category msi = new Category("MSI","Predator");
            Laptop predator = new Laptop(msi, "testLaptopName", "testModel");
            laptopStorage.store(predator);

            Category hp = new Category("HP","hpJunk");
            Laptop hpJunk = new Laptop(hp, "testLaptopName","testModel");
            laptopStorage.store(hpJunk);

            Category alien = new Category("AlienWare", "Aurora");
            Laptop aurora = new Laptop(alien, "testLaptopName", "testModel");
            laptopStorage.store(aurora);

            Category lenovo = new Category("Lenovo", "ThinkPad");
            Laptop thinkPad = new Laptop(lenovo, "testLaptopName", "testModel");
            laptopStorage.store(thinkPad);




            Review review1 = new Review();
            reviewStorage.store(review1);

        }
    }
