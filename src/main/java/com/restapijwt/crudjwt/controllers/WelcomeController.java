package com.restapijwt.crudjwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("welcome")
public class WelcomeController {
    @GetMapping
    public String Welcome(){
        return "Welcome to REST API JWT";
    }
}
