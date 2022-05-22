package com.gllllepulla.controller;

import com.gllllepulla.service.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final SecurityService securityService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestParam(value = "username") String userName,
                                   @RequestParam(value = "password") String password,
                                   HttpServletRequest request) throws IOException {
        Authentication authenticate = securityService.authenticate(userName, password, request);
        record LoginResponse(String response){}
        if (authenticate.isAuthenticated()) {
            return ResponseEntity.ok(new LoginResponse("authenticated"));
        } else {
            return ResponseEntity.status(401).body(new LoginResponse("not authenticated"));
        }
    }

}
