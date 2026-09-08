package com.travelGuide.GuideWeb.Repository;

import com.travelGuide.GuideWeb.Entity.Booking;
import com.travelGuide.GuideWeb.Entity.TripEntity;
import com.travelGuide.GuideWeb.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {


    List<Booking> findByUser(UserEntity user);


}
