package org.wecancodeit.reviews;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoriesControllerTest {
    private MockMvc mockMvc;
    private CategoriesController underTest;
    private CategoriesStorage mockStorage;

    @BeforeEach
    public void setUp() {
        mockStorage = mock(CategoriesStorage.class);
        underTest = new CategoriesController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void categoryControllerShouldInstantiate() throws Exception {
        Categories testCampus = new Categories("MSI");
        List<Categories> categoriesCollection = Collections.singletonList(testCampus);
        when(mockStorage.findAllCategories()).thenReturn(categoriesCollection);
        mockMvc.perform(get("/campuses"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categoriesView"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categoriesCollection));
    }

}