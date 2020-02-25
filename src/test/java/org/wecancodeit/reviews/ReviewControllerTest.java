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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class ReviewControllerTest {
    private MockMvc mockMvc;
    private ReviewController underTest;
    private ReviewStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp(){
        mockModel = mock(Model.class);
        mockStorage = mock(ReviewStorage.class);
        underTest = new ReviewController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }



    @Test
    public void shouldReturnViewWithOneReview(){
        Category testCategory = new Category("MSI");
        Laptop laptop = new Laptop();
        Review testReview = new Review("testLaptopName", "testHashtag", "testReviewText", "testLaptopModel", laptop);
        when(mockStorage.findReviewByLaptopName("testReviewLaptopName")).thenReturn(testReview);
        underTest.displaySingleReview("testReviewLaptopName", mockModel);
        verify(mockStorage).findReviewByLaptopName("testReviewLaptopName");
        verify(mockModel).addAttribute("review", testReview);
    }

    @Test
    public void shouldReturnViewNamedReviewPageViewWhenDisplaySingleReview(){
        String viewName = underTest.displaySingleReview("testReviewLaptopName", mockModel);
        assertThat(viewName).isEqualTo("review-pageView");
    }
}
