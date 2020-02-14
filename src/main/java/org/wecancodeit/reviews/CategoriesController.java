package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CategoriesController {

    private CategoriesStorage categoriesStorage;

    public CategoriesController(CategoriesStorage categoriesStorage) {

        this.categoriesStorage = categoriesStorage;
    }

    @RequestMapping("/categories")
    public String displayCategories(Model model){
        model.addAttribute("categories", categoriesStorage.findAllCategories());
        return "categoriesView";
    }
@RequestMapping ("/categories/{categoriesBrand}")
    public String displaySingleCategory(@PathVariable String categoriesBrand, Model model){
        Categories retrievedCategory = categoriesStorage.findCategoryByBrand(categoriesBrand);
        model.addAttribute("category", retrievedCategory);
        return "Laptops";
    }

}
