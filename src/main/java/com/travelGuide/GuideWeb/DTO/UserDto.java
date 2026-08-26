package com.travelGuide.GuideWeb.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class UserDto {
    private String name;
    private String email;
    private String address;
    private String phone;
    private String gender;

}
