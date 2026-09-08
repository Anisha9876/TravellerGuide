package com.travelGuide.GuideWeb.DTO;

import lombok.Data;

@Data
public class ReviewDto {
    private String comment;
    private int rating;
    private Long tripId;
}
