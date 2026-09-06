package com.travelGuide.GuideWeb.Controller;

import com.travelGuide.GuideWeb.Entity.Booking;
import com.travelGuide.GuideWeb.Service.BookingService;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    BookingService bookingService;
    BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }
    @PostMapping("/{tripId}")
    public Booking bookingTrip(@PathVariable Long tripId,
                               Authentication authentication){
        String email;
        if (authentication.getPrincipal() instanceof OAuth2User oAuth2User) {
            // Case 1: Google OAuth2 login
            email = oAuth2User.getAttribute("email");
        } else {
            // Case 2: JWT login (from Postman)
            email = authentication.getName(); // this is email from your JWT
        }
        System.out.println("Logged in user: " + email);
        return bookingService.bookTrip(tripId,email);

    }
    @GetMapping("/my")
    public List<Booking> getMyBookings(Authentication authentication){
        String email = authentication.getName();
        List<Booking> bookings = bookingService.getBookings(email);
        return bookings;
    }

}
