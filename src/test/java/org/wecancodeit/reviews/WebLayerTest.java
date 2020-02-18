package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.plaf.PanelUI;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CategoriesStorage mockStorage;
    @MockBean
    ReviewStorage mockStorage2;
    @MockBean
    LaptopStorage mockStorage3;

    @Test
    public void categoriesShouldBeOkAndReturnTheCategoriesViewCategoriesModelsAttribute() throws Exception{
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categoriesView"))
                .andExpect(model().attributeExists("categories"));
    }

    @Test
    public void reviewShouldBeOkAndReturnTheReviewPageViewReviewModelsAttribute() throws Exception {
        Review dell = new Review("", "Dell", "", "", "");
       when(mockStorage2.findReviewByLaptopName("dell")).thenReturn(dell);
        mockMvc.perform(get("/review-page/dell"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("review-pageView"))
                .andExpect(model().attributeExists("review"));
    }
    @Test
    public void laptopShouldBeOkReturnAllAttributes() throws Exception{
        mockMvc.perform(get("/laptops"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("Laptops"))
                .andExpect(model().attributeExists("laptops"));

    }


}
