package com.travelGuide.GuideWeb.DTO;

import com.travelGuide.GuideWeb.Entity.Enum.Status;
import com.travelGuide.GuideWeb.Entity.TripEntity;
import com.travelGuide.GuideWeb.Entity.UserEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class BookingDto {
    private Long tripId;
    private Double totalPrice;
}
