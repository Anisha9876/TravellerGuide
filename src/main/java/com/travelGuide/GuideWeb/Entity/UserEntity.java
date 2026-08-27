package com.travelGuide.GuideWeb.Entity;

import com.travelGuide.GuideWeb.Entity.Enum.Role;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class UserEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
