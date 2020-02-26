package org.wecancodeit.reviews.storage;

import ch.qos.logback.core.util.DefaultInvocationGate;
import org.springframework.jca.cci.CannotGetCciConnectionException;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Laptop;
import org.wecancodeit.reviews.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private CategoryStorageJpaImpl categoryStorageJpaImpl;
    private LaptopStorageJpaImpl laptopStorageJpaImpl;
    private ReviewJpaImpl reviewJpa;
    //    private LaptopStorage laptopStorage;
//    private ReviewStorage reviewStorage;


    public Populator(CategoryStorageJpaImpl categoryStorageJpaImpl, LaptopStorageJpaImpl laptopStorageJpaImpl, ReviewJpaImpl reviewJpa) {
        this.categoryStorageJpaImpl = categoryStorageJpaImpl;
        this.laptopStorageJpaImpl = laptopStorageJpaImpl;
        this.reviewJpa = reviewJpa;

    }

    @Override
    public void run(String... args) {

        Category hp = new Category("HP");
        categoryStorageJpaImpl.store(hp);

        Category msi = new Category("MSI");
        categoryStorageJpaImpl.store(msi);

        Category lenovo = new Category("Lenovo");
        categoryStorageJpaImpl.store(lenovo);

        Category alienware = new Category("Alienware");
        categoryStorageJpaImpl.store(alienware);


        Laptop hpOne = new Laptop(hp, "hpName", "hpModel");
        laptopStorageJpaImpl.store(hpOne);

        Laptop msiOne = new Laptop(msi, "msiName", "msiModel");
        laptopStorageJpaImpl.store(msiOne);

        Laptop lenovoOne = new Laptop(lenovo, "lenovoName", "lenovoModel");
        laptopStorageJpaImpl.store(lenovoOne);

        Laptop alienwareOne = new Laptop(alienware, "alienwareName", "alienwareModel");
        laptopStorageJpaImpl.store(alienwareOne);


        Review review1 = new Review("hpOne", "#test", "reviewText", "laptopModel", hpOne);
        reviewJpa.store(review1);

        Review review2 = new Review("msiOne", "#test", "reviewText", "laptopModel", msiOne);
        reviewJpa.store(review2);

        Review review3 = new Review("lenovoOne", "#test", "reviewText", "laptopModel", lenovoOne);
        reviewJpa.store(review3);

        Review review4 = new Review("alienwareOne", "#test", "reviewText", "laptopModel", alienwareOne);
        reviewJpa.store(review4);

    }
}
