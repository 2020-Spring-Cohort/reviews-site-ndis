package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class JPAWiringTest {
@Autowired
    private CategorieRepository categoryRepo;
@Autowired
    private LaptopRepository laptopRepository;
@Autowired
    private ReviewRepository reviewRepository;
@Autowired
private TestEntityManager entityManager;

@Test
public void categoryShouldHaveListOfBrands(){
    Categories testCategory = new Categories("Tbrand");
    Laptop testLaptop = new Laptop();
    Review testReview = new Review("Tname", "Tbrand", "#yo", "idk","abs123");
    categoryRepo.save(testCategory);
    laptopRepository.save(testLaptop);
    reviewRepository.save(testReview);

    entityManager.flush();
    entityManager.clear();

}
}
