package com.travelGuide.GuideWeb.Service;

import com.travelGuide.GuideWeb.DTO.UserDto;
import com.travelGuide.GuideWeb.Entity.UserEntity;
import com.travelGuide.GuideWeb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repo;
    public void registerUser(UserDto dto){


    }
    public UserEntity findByEmail(String email){
        UserEntity user = repo.findByEmail(email);
        return user;
    }


}
