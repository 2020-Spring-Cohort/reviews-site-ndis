package org.wecancodeit.reviews.contorller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.models.Laptop;
import org.wecancodeit.reviews.models.Review;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.storage.ReviewStorage;
import org.wecancodeit.reviews.storage.repos.LaptopRepository;

@Controller
public class ReviewController {
    private ReviewStorage reviewStorage;
    private LaptopRepository laptopRepository;

    public ReviewController(ReviewStorage reviewStorage, LaptopRepository laptopRepository) {
        this.reviewStorage = reviewStorage;
        this.laptopRepository = laptopRepository;
    }

    @RequestMapping("/review-page/{id}")
    public String displaySingleReview(@PathVariable long id, Model model) {
        Review retrievedReview = reviewStorage.findReviewById(id);
        model.addAttribute("review", retrievedReview);
        return "review-page";

    }

    @PostMapping("/{id}/add-review")
    public String addReview(@PathVariable Long id, @RequestParam String reviewText){
        Laptop laptop = laptopRepository.findById(id).get();
        reviewStorage.store(new Review(laptop.getName(), "", reviewText, laptop.getModel(), laptop));
        return "redirect:/laptops/" + laptop.getName();
    }
}
