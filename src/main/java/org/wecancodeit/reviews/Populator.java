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

            categoriesStorage.store(new Categories("HP","akdjsfnka"));
            categoriesStorage.store(new Categories("AlienWare","fnasjdnfasn"));
            categoriesStorage.store(new Categories("Dell","fdgdg"));
            categoriesStorage.store(new Categories("MSI","asdfaf"));
        }
    }
