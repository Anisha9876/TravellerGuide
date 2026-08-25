package com.travelGuide.GuideWeb.Controller;


import com.travelGuide.GuideWeb.DTO.TripDto;
import com.travelGuide.GuideWeb.Entity.TripEntity;
import com.travelGuide.GuideWeb.Mapper.TravelMapper;
import com.travelGuide.GuideWeb.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    TravelMapper mapper;
    @Autowired
    TripService service;
    @PostMapping("/add")
    public TripDto addTrip(@RequestBody TripDto tripDto){
        TripEntity tripEntity = mapper.tripDtoToTripEntity(tripDto);
        TripEntity trip = service.createTrip(tripEntity);
        return mapper.tripEntityToTripDto(trip);
    }
}
