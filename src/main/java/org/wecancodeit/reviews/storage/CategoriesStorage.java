package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Category;

import java.util.Collection;

public interface CategoriesStorage {
    Collection<Category> findAllCategories();

    void store(Category category);
    Category findCategoryByBrand (String categoryBrand);
}