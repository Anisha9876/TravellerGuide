package com.travelGuide.GuideWeb.Service;

import com.travelGuide.GuideWeb.DTO.ReviewDto;
import com.travelGuide.GuideWeb.Entity.Review;
import com.travelGuide.GuideWeb.Entity.TripEntity;
import com.travelGuide.GuideWeb.Entity.UserEntity;
import com.travelGuide.GuideWeb.Mapper.ReviewMapper;
import com.travelGuide.GuideWeb.Repository.ReviewRepository;
import com.travelGuide.GuideWeb.Repository.TripRepository;
import com.travelGuide.GuideWeb.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;
    private TripRepository tripRepository;
    private UserRepository userRepository;
    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper
            , TripRepository tripRepository
            ,UserRepository userRepository){
        this.reviewRepository=reviewRepository;
        this.reviewMapper=reviewMapper;
        this.tripRepository=tripRepository;
        this.userRepository=userRepository;
    }
    public  Review writeReview(ReviewDto review,String email) {
        TripEntity trip = tripRepository.findById(review.getTripId())
                .orElseThrow(() -> new RuntimeException("Trip not found"));
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Review reviewEntity = reviewRepository.save(reviewMapper.dtoToReview(review));
        reviewEntity.setTrip(trip);
        reviewEntity.setUser(user);
        return reviewEntity;
    }

    public List<Review> getAllReviews(Long tripId) {
        return reviewRepository.findByTripId(tripId);

    }
}
