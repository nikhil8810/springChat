package com.app.chat.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class test {
    
    @GetMapping("/hello")
    public String getMethodName() {
        return "hello from server";
    }
    
}
