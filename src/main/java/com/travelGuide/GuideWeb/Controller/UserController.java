package com.travelGuide.GuideWeb.Controller;

import com.travelGuide.GuideWeb.Entity.UserEntity;
import com.travelGuide.GuideWeb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/mail/{mail}")
    public ResponseEntity<UserEntity> getUserByMail(@PathVariable String mail){
        UserEntity user = service.findByEmail(mail);
        return ResponseEntity.ok().body(user);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        UserEntity userEntity = service.deleteUser(id);
        return "Successfully deleted";
    }
}
