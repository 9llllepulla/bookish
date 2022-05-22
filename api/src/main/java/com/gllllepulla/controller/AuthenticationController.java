package com.gllllepulla.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {


    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestParam(value = "username") String userName,
                                   @RequestParam(value = "password") String password,
                                   HttpServletRequest request) throws IOException {

        return ResponseEntity.notFound().build(); // TODO stub
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<?> logOut() {

        return ResponseEntity.notFound().build(); // TODO stub
    }

}
