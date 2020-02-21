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


//            categoryStorageJpaImpl.store(new Category("HP","akdjsfnka"));
//            categoryStorageJpaImpl.store(new Category("AlienWare","fnasjdnfasn"));
//            categoryStorageJpaImpl.store(new Category("Dell","fdgdg"));
//            categoryStorageJpaImpl.store(new Category("MSI","asdfaf"));



            Category msi = new Category("MSI","Predator");
            Laptop predator = new Laptop(msi, "9560NGW");
            laptopStorage.store(predator);

            Category hp = new Category("HP","hpJunk");
            Laptop hpJunk = new Laptop(hp, "sdfgh654");
            laptopStorage.store(hpJunk);

            Category alien = new Category("AlienWare", "Aurora");
            Laptop aurora = new Laptop(alien, "1234");
            laptopStorage.store(aurora);

            Category lenovo = new Category("Lenovo", "ThinkPad");
            Laptop thinkPad = new Laptop(lenovo, "4321");
            laptopStorage.store(thinkPad);



//
//            Review review1 = new Review();
//            reviewStorage.store(review1);

        }
    }
