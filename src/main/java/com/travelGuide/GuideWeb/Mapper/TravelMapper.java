package com.travelGuide.GuideWeb.Mapper;

import com.travelGuide.GuideWeb.DTO.TripDto;
import com.travelGuide.GuideWeb.Entity.TripEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelMapper {
    @Autowired
    TripDto tripDto;
    @Autowired
    TripEntity tripEntity;


    public TripDto tripEntityToTripDto(TripEntity tripEntity){
        tripDto.setTripName(tripEntity.getTripName());
        tripDto.setDestination(tripEntity.getDestination());
        tripDto.setContact(tripEntity.getContact());
        tripDto.setPrice(tripEntity.getPrice());
        tripDto.setDuration(tripEntity.getDuration());
        tripDto.setTravelType(tripEntity.getTravelType());
        tripDto.setPickUp(tripEntity.getPickUp());
        tripDto.setDropLocation(tripEntity.getDropLocation());
        return tripDto;

    }
    public TripEntity tripDtoToTripEntity(TripDto tripDto){
        tripEntity.setContact(tripDto.getContact());
        tripEntity.setDestination(tripDto.getDestination());
        tripEntity.setPrice(tripDto.getPrice());
        tripEntity.setTripName(tripDto.getTripName());
        tripEntity.setDuration(tripDto.getDuration());
        tripEntity.setTravelType(tripDto.getTravelType());
        tripEntity.setDropLocation(tripDto.getDropLocation());
        tripEntity.setPickUp(tripDto.getPickUp());
        return tripEntity;
    }
}
