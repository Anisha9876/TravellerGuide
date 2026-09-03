package com.travelGuide.GuideWeb.Service;

import com.travelGuide.GuideWeb.Entity.Booking;
import com.travelGuide.GuideWeb.Entity.TripEntity;
import com.travelGuide.GuideWeb.Entity.UserEntity;
import com.travelGuide.GuideWeb.Repository.BookingRepository;
import com.travelGuide.GuideWeb.Repository.TripRepository;
import com.travelGuide.GuideWeb.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    public BookingService(TripRepository tripRepository,
                          UserRepository userRepository, BookingRepository bookingRepository) {
        this.tripRepository = tripRepository;
        this.userRepository=userRepository;
        this.bookingRepository=bookingRepository;
    }
    @Transactional
    public Booking bookTrip(Long tripId, String email){
        TripEntity trip = tripRepository.findById(tripId).orElseThrow(()-> new RuntimeException("Trip not found"));
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found: " + email));
        if(trip.getAvailableSit()<=0){
            throw new RuntimeException("Trip is already booked no sit left");
        }
        trip.setAvailableSit(trip.getAvailableSit()-1);
        Booking booking=new Booking();
        booking.setTrip(trip);
        booking.setUser(user);
        booking.setTotalPrice(trip.getPrice());
        return bookingRepository.save(booking);
    }
}
