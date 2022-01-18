package com.self.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class WelcomeController {

    @GetMapping("/test")
    public String getTest() {
        return "<h1>Welcome to spring boot with spring security</h1>";
    }

}
