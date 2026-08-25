package com.travelGuide.GuideWeb.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tripName;
    private Double price;
    private String pickUp;
    private String dropLocation;
    private String contact;
    private String travelType;
    private String destination;
    private String duration;
}
