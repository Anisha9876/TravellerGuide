package com.travelGuide.GuideWeb.Entity;

import com.travelGuide.GuideWeb.Entity.Enum.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class UserEntity {
    @Id()
    private Long id;
    private String name;
    private String email;
    private String address;

    private String password;
    private String phone;
    private String gender;

    @Enumerated(EnumType.STRING)
    private Role role;
}
