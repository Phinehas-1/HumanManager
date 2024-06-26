package com.humanmanager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthController {
    @Value("${project.name}")
    private String projectName;

    @GetMapping
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(projectName + " is live...");
    }
}
