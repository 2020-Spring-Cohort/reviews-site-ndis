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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class LaptopControllerTest {
    private MockMvc mockMvc;
    private LaptopController underTest;
    private LaptopStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(LaptopStorage.class);
        underTest = new LaptopController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

    }

    @Test
    public void laptopControllerShouldInstantiate() throws Exception {
        Laptop testLaptop = new Laptop("MSI", "ABS", "AB123");
        List<Laptop> laptopCollection = Collections.singletonList(testLaptop);
        when(mockStorage.findAllLaptops()).thenReturn(laptopCollection);
        mockMvc.perform(get("/laptops"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("Laptops"))
                .andExpect(model().attributeExists("laptops"))
                .andExpect(model().attribute("laptops", laptopCollection));
    }


    @Test

    public void laptopShouldReturnOneReview() {
        Laptop testLaptop = new Laptop("MSI", "ABS", "AB123");
        when(mockStorage.findLaptopByName("ABS")).thenReturn(testLaptop);
    }

}