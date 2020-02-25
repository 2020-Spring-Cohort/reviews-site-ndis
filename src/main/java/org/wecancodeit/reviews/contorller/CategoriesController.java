package org.wecancodeit.reviews.contorller;

import org.wecancodeit.reviews.models.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.storage.CategoriesStorage;


@Controller
public class CategoriesController {

    private CategoriesStorage categoriesStorage;

    public CategoriesController(CategoriesStorage categoriesStorage) {

        this.categoriesStorage = categoriesStorage;
    }

    @RequestMapping("/category")
    public String displayCategories(Model model) {
        model.addAttribute("category", categoriesStorage.findAllCategories());
        return "categoriesView";
    }

    @RequestMapping("/category/{categoriesBrand}")
    public String displaySingleCategory(@PathVariable String categoriesBrand, Model model) {
        Category retrievedCategory = categoriesStorage.findCategoryByBrand(categoriesBrand);
        model.addAttribute("category", retrievedCategory);
        return "Laptops";
    }

}
