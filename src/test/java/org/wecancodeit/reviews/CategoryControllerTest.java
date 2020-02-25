package org.wecancodeit.reviews;

import org.wecancodeit.reviews.contorller.CategoriesController;
import org.wecancodeit.reviews.models.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.storage.CategoriesStorage;
import org.wecancodeit.reviews.storage.CategoryStorageJpaImpl;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoryControllerTest {
    private MockMvc mockMvc;
    private CategoriesController underTest;
    private CategoriesStorage mockStorage;
    private Model mockModel;
    private CategoryStorageJpaImpl categoryStorageJpaImpl;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(CategoriesStorage.class);
        underTest = new CategoriesController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void categoryControllerShouldInstantiate() throws Exception {
        Category testCategory = new Category("testBrand");
        List<Category> categoryCollection = Collections.singletonList(testCategory);
        when(mockStorage.findAllCategories()).thenReturn(categoryCollection);
        mockMvc.perform(get("/category"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categoriesView"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("category", categoryCollection));
    }

    @Test
    public void shouldReturnViewWithOneCategory() {
        Category testCategory = new Category("testBrand");
        when(mockStorage.findCategoryByBrand("MSI")).thenReturn(testCategory);
        underTest.displaySingleCategory("MSI", mockModel);
        verify(mockStorage).findCategoryByBrand("MSI");
        verify(mockModel).addAttribute("category", testCategory);
    }

    @Test
    public void shouldReturnViewNamedCategoryWhenDisplaySingleCategory() {
        String viewName = underTest.displaySingleCategory("test", mockModel);
        assertThat(viewName).isEqualTo("Laptops");
    }

}