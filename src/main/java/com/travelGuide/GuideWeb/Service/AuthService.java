package com.travelGuide.GuideWeb.Service;

import com.travelGuide.GuideWeb.Config.SecurityConfig;
import com.travelGuide.GuideWeb.DTO.UserDto;
import com.travelGuide.GuideWeb.Entity.UserEntity;
import com.travelGuide.GuideWeb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

     @Autowired
     SecurityConfig config;
     @Autowired
     UserRepository repository;
     public void registration(UserDto dto) {
         UserEntity userEntity = new UserEntity();
        userEntity.setPassword(
                config.passwordEncoder().encode(dto.getPassword())
        );
        repository.save(userEntity);
    }
}
