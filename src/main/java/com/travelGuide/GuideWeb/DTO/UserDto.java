package com.travelGuide.GuideWeb.DTO;

import com.travelGuide.GuideWeb.Entity.Enum.Role;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class UserDto {
    private String name;
    private String email;
    private String address;
    private String phone;
    private String password;
    private String gender;
    private Role role;

}
