package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Categories;

import java.util.Collection;
import java.util.HashMap;


public class MapCategoriesStorage implements CategoriesStorage {
    private HashMap<String, Categories> categoryList;

    public MapCategoriesStorage() {
        categoryList = new HashMap<>();
    }

    @Override
    public Collection<Categories> findAllCategories() {
        return categoryList.values();
    }

    @Override
    public void store(Categories categories) {
        categoryList.put(categories.getBrand(), categories);
    }

    @Override
    public Categories findCategoryByBrand(String categoryBrand) {
        return categoryList.get(categoryBrand);
    }
}