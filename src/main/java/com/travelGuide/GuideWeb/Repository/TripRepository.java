package com.travelGuide.GuideWeb.Repository;

import com.travelGuide.GuideWeb.Entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<TripEntity,Long> {
}
