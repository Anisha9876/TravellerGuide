package com.travelGuide.GuideWeb.Service;

import com.travelGuide.GuideWeb.DTO.GNewsResponse;
import com.travelGuide.GuideWeb.DTO.NewsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class NewsService {
    @Value("${gnews.api.key}")
    private String apiKey;

    private final RestClient restClient = RestClient.create();

    public List<NewsDto> getNews(String destination){
        try {
            GNewsResponse body = restClient.get()
                    .uri("https://gnews.io/api/v4/search?q={destination}&lang=en&max=10&sortby=publishedAt&apikey={key}",
                            destination, apiKey)
                    .retrieve()
                    .body(GNewsResponse.class);
            return body.getArticles();
        }
        catch (Exception e){
            throw new RuntimeException("Failed to fetch news");
        }

    }

}
