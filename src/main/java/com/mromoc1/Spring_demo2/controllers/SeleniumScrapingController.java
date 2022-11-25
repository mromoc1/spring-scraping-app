package com.mromoc1.Spring_demo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mromoc1.Spring_demo2.services.SeleniumScrapingService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/scraping")
public class SeleniumScrapingController {
    SeleniumScrapingService seleniumScrapingService;

    @Autowired
    public SeleniumScrapingController(SeleniumScrapingService seleniumScrapingService) {
        this.seleniumScrapingService = seleniumScrapingService;
    }

    @GetMapping()
    public void scraping() {
        seleniumScrapingService.iniciarScraping();
    }
    


}
