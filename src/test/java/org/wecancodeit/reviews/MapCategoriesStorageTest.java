package org.wecancodeit.reviews;

import org.wecancodeit.reviews.models.Categories;
import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.storage.CategoriesStorage;
import org.wecancodeit.reviews.storage.MapCategoriesStorage;

import static org.assertj.core.api.Assertions.assertThat;

public class MapCategoriesStorageTest {
    @Test
    public void shouldStoreCategoriesInMap() {
        Categories testCategories = new Categories("MSI", "names");
        CategoriesStorage underTest = new MapCategoriesStorage();
        underTest.store(testCategories);
        assertThat(underTest.findAllCategories().contains(testCategories));
    }

    @Test
    public void shouldRetrieveSingleCategory() {
        Categories testCategory = new Categories("Test", "names");
        Categories testCategory2 = new Categories("Msi","namesfgh");
        MapCategoriesStorage underTest = new MapCategoriesStorage();
        underTest.store(testCategory);
        underTest.store(testCategory2);
        Categories retrieveCategories = underTest.findCategoryByBrand("Test");
        assertThat(retrieveCategories).isEqualTo(testCategory);
    }
}
