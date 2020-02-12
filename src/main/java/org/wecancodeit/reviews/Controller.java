package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Products {

    private ProductsStorage productsStorage;

    public Products(ProductsStorage productsStorage) {

        this.productsStorage = productsStorage;
    }

    @RequestMapping("/categories")
    public String displayCategories(Model model){
        model.addAttribute("categories", productsStorage.findAllProducts());
        return "prodcutview";
    }

}
