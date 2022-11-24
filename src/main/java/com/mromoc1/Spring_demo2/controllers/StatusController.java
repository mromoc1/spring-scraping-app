package com.mromoc1.Spring_demo2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatusController {
    
    @RequestMapping("/status")
    public String health() {
        return "OK";
    }
}
