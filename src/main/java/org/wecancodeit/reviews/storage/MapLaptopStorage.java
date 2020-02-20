package org.wecancodeit.reviews.storage;


import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Laptop;

import java.util.Collection;
import java.util.HashMap;

@Service
public class MapLaptopStorage implements LaptopStorage{

    private HashMap<String, Laptop> laptopList;

    public MapLaptopStorage(){
        laptopList = new HashMap<>();
    }

    @Override
        public Collection<Laptop> findAllLaptops(){
            return laptopList.values();
    }

    @Override
            public void store(Laptop laptop){
            laptopList.put(laptop.getName(), laptop);
        }

    @Override
    public Laptop findLaptopByName(String laptopName) {
        return laptopList.get(laptopName);
    }


}



