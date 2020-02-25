package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Laptop;
import org.wecancodeit.reviews.storage.LaptopStorage;
import org.wecancodeit.reviews.storage.LaptopStorageJpaImpl;
import org.wecancodeit.reviews.storage.repos.LaptopRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class LaptopStorageJpaImplTest {
    @Test
    public void shouldFindAllLaptops() {
        LaptopRepository mockLaptopRepository = mock(LaptopRepository.class);
        Category category = new Category("testBrand");
        Laptop testLaptop = new Laptop(category, "testName", "testModel");
        LaptopStorage underTest = new LaptopStorageJpaImpl(mockLaptopRepository);
        when(mockLaptopRepository.findAll()).thenReturn(Collections.singletonList(testLaptop));
        underTest.store(testLaptop);
        verify(mockLaptopRepository).save(testLaptop);
        assertThat(underTest.findAllLaptops()).contains(testLaptop);
    }

    @Test
    public void shouldRetrieveSingleReviewByLaptop() {
        LaptopRepository mockLaptopRepository = mock(LaptopRepository.class);
        Category category = new Category("testBrand");
        Laptop testLaptop1 = new Laptop(category, "testLaptopName1", "testModel");
        Laptop testLaptop2 = new Laptop(category, "testLaptopName2", "testModel");
        LaptopStorage underTest = new LaptopStorageJpaImpl(mockLaptopRepository);
        underTest.store(testLaptop1);
        underTest.store(testLaptop2);
        Optional<Laptop> testLaptop1Optional = Optional.of(testLaptop1);
        when(mockLaptopRepository.findByName("testLaptopName1")).thenReturn(testLaptop1Optional);

        Optional<Laptop> testLaptop2Optional = Optional.of(testLaptop2);
        when(mockLaptopRepository.findByName("testLaptopName2")).thenReturn(testLaptop2Optional);

        Laptop retrievedLaptop1 = underTest.findLaptopByName("testLaptopName1");
        Laptop retrievedLaptop2 = underTest.findLaptopByName("testLaptopName2");
        assertThat(retrievedLaptop1).isEqualTo(testLaptop1);
        assertThat(retrievedLaptop2).isEqualTo(testLaptop2);
    }
}
