package com.travelGuide.GuideWeb.Controller;

import com.travelGuide.GuideWeb.Entity.UserEntity;
import com.travelGuide.GuideWeb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/mail/{mail}")
    public ResponseEntity<UserEntity> getUserByMail(@PathVariable String mail){
        UserEntity user = service.findByEmail(mail);
        return ResponseEntity.ok().body(user);
    }
}
