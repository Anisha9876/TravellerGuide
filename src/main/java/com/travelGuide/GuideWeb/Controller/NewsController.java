package com.travelGuide.GuideWeb.Controller;

import com.travelGuide.GuideWeb.DTO.NewsDto;
import com.travelGuide.GuideWeb.Service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    NewsService newsService;
    NewsController(NewsService newsService){
        this.newsService=newsService;
    }
    @GetMapping("/news/{destination}")
    public List<NewsDto> news(@PathVariable String destination){

        return newsService.getNews(destination);

    }
}
