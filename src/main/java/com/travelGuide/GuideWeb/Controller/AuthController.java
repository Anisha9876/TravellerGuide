package com.travelGuide.GuideWeb.Controller;

import com.travelGuide.GuideWeb.DTO.LoginDto;
import com.travelGuide.GuideWeb.DTO.UserDto;
import com.travelGuide.GuideWeb.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> registration(@RequestBody UserDto dto){
        service.registration(dto);
        return ResponseEntity.ok("Successfully Registered");
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto){
        String token = service.login(dto);
        return ResponseEntity.ok().body(token);
    }
}
