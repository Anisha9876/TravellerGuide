package com.travelGuide.GuideWeb.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoginDto {
    private String email;
    private String password;
}
