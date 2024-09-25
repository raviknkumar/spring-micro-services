package com.example.order_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/greet")
public class GreetingController {
    // Value coming from config server
    @Value ("${appConfig.greet.message}")
    private String message;

    @GetMapping
    public ResponseEntity<String> greetUser() {
        return ResponseEntity.ok(message);
    }
}
