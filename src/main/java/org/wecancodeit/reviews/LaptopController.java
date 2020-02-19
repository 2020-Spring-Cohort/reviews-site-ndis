package org.wecancodeit.reviews;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LaptopController {
    private LaptopStorage laptopStorage;

    public LaptopController(LaptopStorage laptopStorage) {
        this.laptopStorage = laptopStorage;
    }


        @RequestMapping("/laptops")
                public String displayLaptops( Model model) {
            model.addAttribute("laptops", laptopStorage.findAllLaptops());
            return "Laptops";
        }

            @RequestMapping ("/laptops/{laptopName}")
            public String displaySingleReview(@PathVariable String laptopName, Model model){
            Laptop retrievedLaptop = laptopStorage.findLaptopByName(laptopName);
            model.addAttribute("laptop",retrievedLaptop);
            return "review-pageView";
        }



}
