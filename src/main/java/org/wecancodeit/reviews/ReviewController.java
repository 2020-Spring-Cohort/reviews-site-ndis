package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
    private ReviewStorage reviewStorage;

    public ReviewController(ReviewStorage reviewStorage){
        this.reviewStorage = reviewStorage;
    }
    @RequestMapping("/review-page")
    public String displayReview(Model model){
        model.addAttribute("review-page", reviewStorage.findAllReviews());
        return "review-pageView";
    }
    @RequestMapping("/review-page/{reviewLaptopName}")
    public String displaySingleReview(@PathVariable String reviewLaptopName, Model model){
        Review retrievedReview = reviewStorage.findReviewByLaptopName(reviewLaptopName);
        model.addAttribute("review-page", retrievedReview);
        return "review-pageView";
    }

}
