package com.self.section2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notices")
public class NoticesController {

    @GetMapping("/")
    public String getNotices(String input){
        return "Here is the notice detail from db";
    }

}
