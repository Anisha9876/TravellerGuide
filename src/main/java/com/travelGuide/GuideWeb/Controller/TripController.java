package com.travelGuide.GuideWeb.Controller;


import com.travelGuide.GuideWeb.DTO.TripDto;
import com.travelGuide.GuideWeb.Entity.TripEntity;
import com.travelGuide.GuideWeb.Mapper.TravelMapper;
import com.travelGuide.GuideWeb.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    TravelMapper mapper;
    @Autowired
    TripService service;
    @PostMapping("/add")
    public ResponseEntity<TripDto> addTrip(@RequestBody TripDto tripDto){
        TripEntity tripEntity = mapper.tripDtoToTripEntity(tripDto);
        TripEntity trip = service.createTrip(tripEntity);
        return ResponseEntity.ok(mapper.tripEntityToTripDto(trip));
    }
    @GetMapping("/getAll")
    public List<TripEntity> getAllTrips(){
        List<TripEntity> trips = service.getTrips();
        return trips;
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<TripEntity>> getById(@PathVariable Long id){
        Optional<TripEntity> tripsById = service.getTripsById(id);
        return ResponseEntity.ok().body(tripsById);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<TripDto> getByName(@PathVariable String name){
        TripEntity tripByName = service.getTripByName(name);
       return ResponseEntity.ok().body( mapper.tripEntityToTripDto(tripByName));
    }
    @GetMapping("/pickup/{pickUp}")
    public ResponseEntity<TripDto> getByPickUp(@PathVariable String pickUp){
        TripEntity tripByPickUp = service.getTripByPickUp(pickUp);
        
        return ResponseEntity.ok().body(mapper.tripEntityToTripDto(tripByPickUp));
    }
    @GetMapping("/dest/{destination}")
    public ResponseEntity<TripEntity> getByDest(@PathVariable String destination){
        TripEntity tripByDestination = service.getTripByDestination(destination);
        return ResponseEntity.ok().body(tripByDestination);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrip(@PathVariable Long id){
        service.deleteTripById(id);
        return ResponseEntity.ok("Successfully deleted ");

    }

}
