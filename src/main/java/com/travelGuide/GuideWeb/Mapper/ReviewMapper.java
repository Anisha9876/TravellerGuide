package com.travelGuide.GuideWeb.Mapper;

import com.travelGuide.GuideWeb.DTO.ReviewDto;
import com.travelGuide.GuideWeb.Entity.Review;
import org.springframework.stereotype.Component;


@Component
public class ReviewMapper {
    public ReviewDto reviewToDto(Review review) {
        ReviewDto dto = new ReviewDto();

        dto.setComment(review.getComment());
        dto.setRating(review.getRating());
        dto.setTripId(review.getTrip().getId());

        return dto;
    }

    public Review dtoToReview(ReviewDto dto) {
        Review review = new Review();

        review.setComment(dto.getComment());
        review.setRating(dto.getRating());

        return review;
    }
}
