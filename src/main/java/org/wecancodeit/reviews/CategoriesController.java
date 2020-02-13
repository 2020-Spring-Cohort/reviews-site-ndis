package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "categoriesview";
    }

}
