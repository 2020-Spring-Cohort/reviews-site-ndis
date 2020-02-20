package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Categories;

import java.util.Collection;

public interface CategoriesStorage {
    Collection<Categories> findAllCategories();

    void store(Categories categories);
    Categories findCategoryByBrand (String categoryBrand);
}