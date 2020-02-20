package org.wecancodeit.reviews.contorller;


        import org.wecancodeit.reviews.models.Laptop;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.wecancodeit.reviews.storage.LaptopStorage;

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

    @RequestMapping ("/laptops/{laptopsName}")
    public String displaySingleReview(@PathVariable String laptopsName, Model model){
        Laptop retrievedReview = laptopStorage.findLaptopByName(laptopsName);
        model.addAttribute("laptop",retrievedReview);
        return "review-pageView";
    }



}
