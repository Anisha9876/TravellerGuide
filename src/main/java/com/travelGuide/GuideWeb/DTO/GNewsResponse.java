package com.travelGuide.GuideWeb.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class GNewsResponse {
    private int totalArticles;
    private List<NewsDto> articles;
}
