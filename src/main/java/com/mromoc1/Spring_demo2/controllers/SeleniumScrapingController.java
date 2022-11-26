package com.mromoc1.Spring_demo2.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mromoc1.Spring_demo2.services.SeleniumScrapingService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/scraping")
public class SeleniumScrapingController {
    SeleniumScrapingService seleniumScrapingService;
    private static final Logger log = LoggerFactory.getLogger(SeleniumScrapingController.class);

    @Autowired
    public SeleniumScrapingController(SeleniumScrapingService seleniumScrapingService) {
        this.seleniumScrapingService = seleniumScrapingService;
    }

    @GetMapping()
    public void scraping() {
        try {
            log.info("GET|202");
            seleniumScrapingService.iniciarScraping();
            log.info("GET|200");
        } catch (Exception e) {
            log.error("GET|400|"+e.getMessage());
        }
    }
}
