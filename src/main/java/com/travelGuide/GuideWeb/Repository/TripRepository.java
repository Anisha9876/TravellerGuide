package com.travelGuide.GuideWeb.Repository;

import com.travelGuide.GuideWeb.Entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<TripEntity,Long> {
    TripEntity findByTripName(String tripName);

    TripEntity findByPickUp(String pickUp);

    TripEntity findByDestination(String destination);

    @Query("""
            SELECT t FROM TripEntity t
            WHERE (:destination IS NULL OR t.destination = :destination)
                      AND (:minPrice IS NULL OR t.price >= :minPrice)
                      AND (:maxPrice IS NULL OR t.price <= :maxPrice)
                     AND (:travelType IS NULL OR t.travelType = :travelType)
            
            """)
    List<TripEntity> searchTrips(String destination, String maxPrice, String minPrice, String travelType);
}
