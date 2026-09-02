package com.travelGuide.GuideWeb.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class NewsDto {
    private String title;
    private String description;
    private String url;
    private String image;
    private String publishedAt;
    private SourceDto source;
}
