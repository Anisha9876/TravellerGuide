package com.travelGuide.GuideWeb.Entity;

import com.travelGuide.GuideWeb.Entity.Enum.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private int rating;
    private LocalDateTime createdAt;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private TripEntity trip;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
