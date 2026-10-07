package com.SpringBackend.spring_back.Controller;

import com.SpringBackend.spring_back.DTO.RegisterRequest;
import com.SpringBackend.spring_back.Model.Users;
import com.SpringBackend.spring_back.Services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserServices userServices;


    public AuthController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req){
        try {
            Users u = userServices.UserRegister(req);
            return ResponseEntity.ok("Зарегистрирован" + u.getUsername());
        }catch (IllegalArgumentException | IllegalStateException e){
            return ResponseEntity.badRequest().body(Map.of("error ", e.getMessage()));
        }
    }


}


