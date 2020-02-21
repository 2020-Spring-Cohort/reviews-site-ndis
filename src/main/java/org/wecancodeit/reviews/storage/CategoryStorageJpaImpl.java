package org.wecancodeit.reviews.storage;

import org.wecancodeit.reviews.models.Category;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.storage.repos.CategoryRepository;

import java.util.Collection;

@Service
public class CategoryStorageJpaImpl implements CategoriesStorage{

    private CategoryRepository categoryRepository;

    public CategoryStorageJpaImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Collection<Category> findAllCategories(){
        return (Collection<Category>) categoryRepository.findAll();
    }

    @Override
    public void store(Category category){
        categoryRepository.save(category);}

    @Override
    public Category findCategoryByBrand(String categoriesBrand){
        return categoryRepository.findByBrand(categoriesBrand).get();
    }

}
