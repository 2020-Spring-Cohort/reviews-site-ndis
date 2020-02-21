package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Category;

import java.util.Collection;
import java.util.HashMap;


public class MapCategoriesStorage implements CategoriesStorage {
    private HashMap<String, Category> categoryList;

    public MapCategoriesStorage() {
        categoryList = new HashMap<>();
    }

    @Override
    public Collection<Category> findAllCategories() {
        return categoryList.values();
    }

    @Override
    public void store(Category category) {
        categoryList.put(category.getBrand(), category);
    }

    @Override
    public Category findCategoryByBrand(String categoryBrand) {
        return categoryList.get(categoryBrand);
    }
}