package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Populator implements CommandLineRunner {

    @Autowired
    CategoriesStorage categoriesStorage;


    public Populator(CategoriesStorage categoriesStorage) {
        this.categoriesStorage = categoriesStorage;
    }
        @Override
        public void run (String... args) throws Exception {


            Categories hp = new Categories("HP");
            categoriesStorage.store(hp);
            categoriesStorage.store(new Categories("AlienWare"));
            categoriesStorage.store(new Categories("Dell"));
            categoriesStorage.store(new Categories("MSI"));
        }
    }
