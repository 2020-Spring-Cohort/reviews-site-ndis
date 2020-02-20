package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Categories;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.storage.repos.CategorieRepository;

import java.util.Collection;

@Service
public class CategoryStorageJpaImpl implements CategoriesStorage{

    private CategorieRepository categorieRepository;

    public CategoryStorageJpaImpl(CategorieRepository categorieRepository){
        this.categorieRepository = categorieRepository;
    }
    @Override
    public Collection<Categories> findAllCategories(){
        return (Collection<Categories>) categorieRepository.findAll();
    }

    @Override
    public void store(Categories categories){categorieRepository.save(categories);}

    @Override
    public Categories findCategoryByBrand(String categoriesBrand){
        return categorieRepository.findByBrand(categoriesBrand).get();
    }

}
