package com.travelGuide.GuideWeb.DTO;

import lombok.Data;

@Data
public class TripDto {

        private String tripName;
        private Double price;
        private String pickUp;
        private String dropLocation;
        private String contact;
        private String travelType;
        private String destination;
        private String duration;

}
