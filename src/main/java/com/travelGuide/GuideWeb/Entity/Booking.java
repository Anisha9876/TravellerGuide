package com.travelGuide.GuideWeb.Entity;

import com.travelGuide.GuideWeb.Entity.Enum.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private TripEntity trip;
    @Enumerated(EnumType.STRING)
    private Status bookingStatus;
    private Double totalPrice;
    private LocalDateTime createdAt;
    @ManyToOne
    private UserEntity user;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.bookingStatus = Status.CONFIRMED;
    }


}
