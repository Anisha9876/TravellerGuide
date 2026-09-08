package com.travelGuide.GuideWeb.Controller;

import com.travelGuide.GuideWeb.DTO.ReviewDto;
import com.travelGuide.GuideWeb.Entity.Review;
import com.travelGuide.GuideWeb.Service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @GetMapping("/trip/{id}")
    public List<Review> getReviews(@PathVariable Long id){
       return reviewService.getAllReviews(id);
    }
    @PostMapping("/")
    public Review review(@Valid @RequestBody ReviewDto review
            , Authentication authentication){
        String email = authentication.getName();
        return reviewService.writeReview(review,email);
    }
}
