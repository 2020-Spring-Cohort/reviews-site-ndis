package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapCategoriesStorageTest {
    @Test
    public void shouldStoreCategoriesInMap(){
        Categories testCategories = new Categories("MSI");
        CategoriesStorage underTest = new MapCategoriesStorage();
        underTest.store(testCategories);
        assertThat(underTest.findAllCategories().contains(testCategories));
    }
}
