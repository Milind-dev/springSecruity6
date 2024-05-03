package com.udmey.spring.springjwt.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
    @GetMapping("/public")
    public String getPublicContent() {
        return "Your public content";
    }

    @GetMapping("/protected")
    public String getProtectedContent() {
        return "Your protected content";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminContent() {
        return "Your admin content";
    }
}
