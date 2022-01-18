package com.self.section2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @GetMapping("/")
    public String getBalance(String input){
        return "Here is the balance detail from db";
    }

}
