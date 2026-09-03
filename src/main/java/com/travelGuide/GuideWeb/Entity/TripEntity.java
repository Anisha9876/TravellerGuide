package com.travelGuide.GuideWeb.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tripName;
    private Double price=100.0;
    private String pickUp;
    private String dropLocation;
    private String contact;
    private String travelType;
    private String destination;
    private String duration;
    private int availableSit=100;
    @OneToMany(mappedBy = "trip")
    @JsonIgnore
    private List<Booking> bookings=new ArrayList<>();
}
