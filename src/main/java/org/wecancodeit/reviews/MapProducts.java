package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
@Service
public class MapCampusStorage implements ProductsStorage {
    private HashMap<String, Categories> categories;

    public MapCampusStorage(){
        categories = new HashMap<>();
    }
    @Override
    public Collection<Categories> findAllProducts() {
        return categories.values();
    }

    @Override
    public void store(Categories campus) {
        categories.put(campus.getBrand(),campus);
    }
}