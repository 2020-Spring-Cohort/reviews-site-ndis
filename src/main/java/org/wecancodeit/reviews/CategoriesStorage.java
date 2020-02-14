package org.wecancodeit.reviews;

import java.util.Collection;

public interface CategoriesStorage {
    Collection<Categories> findAllCategories();

    void store(Categories categories);
    Categories findCategoryByBrand (String categoryBrand);
}