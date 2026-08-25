package com.travelGuide.GuideWeb.Service;

import com.travelGuide.GuideWeb.Entity.TripEntity;
import com.travelGuide.GuideWeb.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    @Autowired
    TripRepository repository;
    public TripEntity createTrip(TripEntity tripEntity){
        TripEntity save = repository.save(tripEntity);
        return save;
    }

}
