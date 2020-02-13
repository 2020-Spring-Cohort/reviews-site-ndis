package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;

@Service
public class MapCategoriesStorage implements CategoriesStorage {
    private HashMap<String, Categories> categoryList;

    public MapCategoriesStorage(){
        categoryList = new HashMap<>();
    }
    @Override
    public Collection<Categories> findAllCategories() {
        return categoryList.values();
    }

    @Override
    public void store(Categories categories) {
        categoryList.put(categories.getBrand(),categories);
    }
}