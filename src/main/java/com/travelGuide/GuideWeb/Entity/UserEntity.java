package com.travelGuide.GuideWeb.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelGuide.GuideWeb.Entity.Enum.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
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
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Booking> bookings=new ArrayList<>();
}
