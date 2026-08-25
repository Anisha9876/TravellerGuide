package com.travelGuide.GuideWeb.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
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
