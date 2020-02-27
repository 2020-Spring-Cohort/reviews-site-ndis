package org.wecancodeit.reviews;

import org.wecancodeit.reviews.contorller.ReviewController;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Laptop;
import org.wecancodeit.reviews.models.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.storage.ReviewStorage;
import org.wecancodeit.reviews.storage.repos.LaptopRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class ReviewControllerTest {
    private MockMvc mockMvc;
    private ReviewController underTest;
    private ReviewStorage mockStorage;
    private LaptopRepository mockStorage2;
    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(ReviewStorage.class);
        mockStorage2 = mock(LaptopRepository.class);
        underTest = new ReviewController(mockStorage, mockStorage2);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }


    @Test
    public void shouldReturnViewWithOneReview() {
        Category testCategory = new Category("MSI");
        Laptop laptop = new Laptop();
        Review testReview = new Review("testLaptopName", "testHashtag", "testReviewText", "testLaptopModel", laptop);
        when(mockStorage.findReviewById(13)).thenReturn(testReview);
        underTest.displaySingleReview(13, mockModel);
        verify(mockStorage).findReviewById(13);
        verify(mockModel).addAttribute("review", testReview);
    }

    @Test
    public void shouldReturnViewNamedReviewPageViewWhenDisplaySingleReview() {
        String viewName = underTest.displaySingleReview(13, mockModel);
        assertThat(viewName).isEqualTo("review-pageView");
    }
}
