package com.travelGuide.GuideWeb.Service;

import com.travelGuide.GuideWeb.DTO.TripDto;
import com.travelGuide.GuideWeb.Entity.TripEntity;
import com.travelGuide.GuideWeb.Mapper.TravelMapper;
import com.travelGuide.GuideWeb.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    TripRepository repository;
    @Autowired
    TravelMapper mapper;
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

    public TripEntity updateTripById(Long id, TripDto dto) {
        TripEntity trip = repository.findById(id).orElseThrow(()->new RuntimeException("No trip exist in this id"));
        trip.setTripName(dto.getTripName());
        trip.setPrice(dto.getPrice());
        trip.setPickUp(dto.getPickUp());
        trip.setDropLocation(dto.getDropLocation());
        trip.setContact(dto.getContact());
        trip.setTravelType(dto.getTravelType());
        trip.setDestination(dto.getDestination());
        trip.setDuration(dto.getDuration());


        return repository.save(trip);

    }

    public List<TripEntity> getSearchFilters(String destination, String maxPrice, String minPrice, String travelType) {
        List<TripEntity> tripEntities = repository.searchTrips(destination, maxPrice, minPrice, travelType);
        return tripEntities;
    }
}
