package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        Review testReview = new Review("testName", "testBrand", "testHashtag", "testReviewText", "testLaptopModel");
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
