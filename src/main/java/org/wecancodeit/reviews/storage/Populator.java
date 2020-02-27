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


        Laptop hpOne = new Laptop(hp, "Envy", "13T");
        laptopStorageJpaImpl.store(hpOne);
        Laptop hpTwo = new Laptop(hp, "HP14", "14T");
        laptopStorageJpaImpl.store(hpTwo);
        Laptop hpThree = new Laptop(hp, "Pavilion", "15T");
        laptopStorageJpaImpl.store(hpThree);
        Laptop hpFour = new Laptop(hp, "Envy x360", "15T touch");
        laptopStorageJpaImpl.store(hpFour);

        Laptop msiOne = new Laptop(msi, "GS75", "Stealth-413");
        laptopStorageJpaImpl.store(msiOne);
        Laptop msiTwo = new Laptop(msi, "P65", "Creator-1084");
        laptopStorageJpaImpl.store(msiTwo);
        Laptop msiThree = new Laptop(msi, "PS42", "8M-064US");
        laptopStorageJpaImpl.store(msiThree);
        Laptop msiFour = new Laptop(msi, "CUK", "GF65");
        laptopStorageJpaImpl.store(msiFour);

        Laptop lenovoOne = new Laptop(lenovo, "ThinkPad", "P52s");
        laptopStorageJpaImpl.store(lenovoOne);
        Laptop lenovoTwo = new Laptop(lenovo, "Yoga", "730");
        laptopStorageJpaImpl.store(lenovoTwo);
        Laptop lenovoThree = new Laptop(lenovo, "IdeaPad", "i5");
        laptopStorageJpaImpl.store(lenovoThree);
        Laptop lenovoFour = new Laptop(lenovo, "Flex", "14 2-1");
        laptopStorageJpaImpl.store(lenovoFour);

        Laptop alienwareOne = new Laptop(alienware, "Alienware17", "ALW17");
        laptopStorageJpaImpl.store(alienwareOne);
        Laptop alienwareTwo = new Laptop(alienware, "AlienwareM17", "M17");
        laptopStorageJpaImpl.store(alienwareTwo);
        Laptop alienwareThree = new Laptop(alienware, "AlienwareM15", "M15");
        laptopStorageJpaImpl.store(alienwareThree);
        Laptop alienwareFour = new Laptop(alienware, "AlienwareR5", "R5");
        laptopStorageJpaImpl.store(alienwareFour);


        Review review1 = new Review("Envy", "#test", "Envy is dope.", "laptopModel", hpOne);
        reviewJpa.store(review1);
        Review review2 = new Review("HP14", "#test", "HP14 is meh.", "laptopModel", hpTwo);
        reviewJpa.store(review2);
        Review review3 = new Review("Pavilion", "#test", "Pavilion is aight.", "laptopModel", hpThree);
        reviewJpa.store(review3);
        Review review4 = new Review("Envy x360", "#test", "Envyx360 is 360x more dope than Envy.", "laptopModel", hpFour);
        reviewJpa.store(review4);

        Review review5 = new Review("GS75", "#test", "GS75 leaves something to be desired.", "laptopModel", msiOne);
        reviewJpa.store(review5);
        Review review6 = new Review("P65", "#test", "P65 is great.", "laptopModel", msiTwo);
        reviewJpa.store(review6);
        Review review7 = new Review("PS42", "#test", "PS42 is average.", "laptopModel", msiThree);
        reviewJpa.store(review7);
        Review review8 = new Review("CUK", "#test", "CUK is unfortunately named.", "laptopModel", msiFour);
        reviewJpa.store(review8);

        Review review9 = new Review("ThinkPad", "#test", "ThinkPad gets the job done.", "laptopModel", lenovoOne);
        reviewJpa.store(review9);
        Review review10 = new Review("Yoga", "#test", "Yoga is very flexible.", "laptopModel", lenovoTwo);
        reviewJpa.store(review10);
        Review review11 = new Review("IdeaPad", "#test", "IdeaPad is an ideal laptop.", "laptopModel", lenovoThree);
        reviewJpa.store(review11);
        Review review12 = new Review("Flex", "#test", "Flex is also flexible.", "laptopModel", lenovoFour);
        reviewJpa.store(review12);

        Review review13 = new Review("Alienware17", "#test", "Alienware17 is out of this world.", "laptopModel", alienwareOne);
        reviewJpa.store(review13);
        Review review14 = new Review("AlienwareM17", "#test", "AlienwareM17 is a serviceable laptop.", "laptopModel", alienwareTwo);
        reviewJpa.store(review14);
        Review review15 = new Review("AlienwareM15", "#test", "AlienwareM15 sucks.", "laptopModel", alienwareThree);
        reviewJpa.store(review15);
        Review review16 = new Review("AlienwareR5", "#test", "AlienwareR5 is not worth the money.", "laptopModel", alienwareFour);
        reviewJpa.store(review16);

    }
}
