package com.travelGuide.GuideWeb.Service;

import com.travelGuide.GuideWeb.Config.SecurityConfig;
import com.travelGuide.GuideWeb.DTO.LoginDto;
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
         userEntity.setName(dto.getName());
         userEntity.setGender(dto.getGender());
         userEntity.setEmail(dto.getEmail());
         userEntity.setAddress(dto.getAddress());
         userEntity.setRole(dto.getRole());
         userEntity.setPhone(dto.getPhone());
        repository.save(userEntity);
    }

    public String login(LoginDto dto){
        String email = dto.getEmail();
        UserEntity user = repository.findByEmail(email);
        if(user ==null){
            return "User not exists plz register again";
        }
       if( !config.passwordEncoder().matches(dto.getPassword(), user.getPassword())){
           return "Incorrect username/Password";
       }
        return "Login successfully";
    }
}
