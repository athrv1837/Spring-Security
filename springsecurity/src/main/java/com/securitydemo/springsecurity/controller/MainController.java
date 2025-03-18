package com.securitydemo.springsecurity.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MainController {

    @GetMapping("/")
    public String getMethodName() {
        return "Hello World";
    }
    
}
