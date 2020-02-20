package org.wecancodeit.reviews;

import org.wecancodeit.reviews.models.Categories;
import org.wecancodeit.reviews.models.Laptop;
import org.wecancodeit.reviews.models.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.wecancodeit.reviews.storage.repos.CategorieRepository;
import org.wecancodeit.reviews.storage.repos.LaptopRepository;
import org.wecancodeit.reviews.storage.repos.ReviewRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ComponentScan
@DataJpaTest
public class JPAWiringTest {

@Autowired
    private CategorieRepository categorieRepository;
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
    Review testReview = new Review("Tname", testCategory, "#yo", "idk","abs123");

    categorieRepository.save(testCategory);
    laptopRepository.save(testLaptop);
    reviewRepository.save(testReview);

    entityManager.flush();
    entityManager.clear();

    Optional<Categories> retreivedCategroeiesOptional = categorieRepository.findById(testCategory.getId());
    Categories retreivedCategories = retreivedCategroeiesOptional.get();
    Laptop retreivedLaptop = laptopRepository.findById(testLaptop.getId()).get();

    assertThat (retreivedCategories.getReviews()).contains(testReview);
}
}
