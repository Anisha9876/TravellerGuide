package com.travelGuide.GuideWeb.Service;

import com.travelGuide.GuideWeb.Entity.TripEntity;
import com.travelGuide.GuideWeb.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    TripRepository repository;
    public TripEntity createTrip(TripEntity tripEntity){
        TripEntity save = repository.save(tripEntity);
        return save;
    }
    public List<TripEntity> getTrips(){
        List<TripEntity> all = repository.findAll();
        return all;
    }
    public Optional<TripEntity> getTripsById(Long id){
        Optional<TripEntity> byId = repository.findById(id);
        return byId;
    }
    public TripEntity getTripByName(String name){
        TripEntity trip = repository.findByTripName(name);
        return trip;
    }

    public TripEntity getTripByPickUp(String pickUp) {
        TripEntity byPickUp = repository.findByPickUp(pickUp);
        return byPickUp;
    }

    public TripEntity getTripByDestination(String destination) {
        TripEntity byDestination = repository.findByDestination(destination);
        return byDestination;
    }

    public void deleteTripById(Long id) {
        TripEntity trip = repository.findById(id).orElseThrow(() -> new RuntimeException("Trip not found"));
        repository.delete(trip);
    }
}
