package com.mromoc1.Spring_demo2.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mromoc1.Spring_demo2.models.SitioWeb;
import com.mromoc1.Spring_demo2.services.SitioWebService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/sitioweb")
public class SitioWebController {
    private final SitioWebService sitioWebService;
    private static final Logger log = LoggerFactory.getLogger(SeleniumScrapingController.class);

    @Autowired
    public SitioWebController(SitioWebService sitioWebService) {
        this.sitioWebService = sitioWebService;
    }

    @PostMapping
    public void save(@RequestBody final SitioWeb sitioWeb) {
        try {
            log.info("POST|202|"+sitioWeb.getSitio());
            sitioWebService.save(sitioWeb);
            log.info("POST|200|"+sitioWeb.getSitio());
        } catch (Exception e) {
            log.error("POST|400|"+e.getMessage());
        }
    }

    @GetMapping
    public Iterable<SitioWeb> obtenerSitiosWeb() {
        try {
            log.info("GET|202");
            Iterable<SitioWeb> var =  sitioWebService.obtenerTodos();
            log.info("GET|200");
            return var;
        } catch (Exception e) {
            log.error("GET|400|"+e.getMessage());
            return null;
        }
        
    }

    @GetMapping("/{sitio}")
    public Iterable<SitioWeb> obtenerSitioWeb(@PathVariable final String sitio) {
        try {
            log.info("GET|202|"+sitio);
            Iterable<SitioWeb> var =  sitioWebService.obtenerSitio(sitio);
            log.info("GET|200|"+sitio);
            return var;
        } catch (Exception e) {
            log.error("GET|400|"+e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarSitioWeb(@PathVariable final String id) {
        try {
            log.info("DELETE|202|"+id);
            sitioWebService.eliminarSitio(id);
            log.info("DELETE|200|"+id);
        } catch (Exception e) {
            log.error("DELETE|400|"+e.getMessage());
        }
    }
    
    
}
