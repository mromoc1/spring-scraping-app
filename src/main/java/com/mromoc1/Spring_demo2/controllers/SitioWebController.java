package com.mromoc1.Spring_demo2.controllers;

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

    @Autowired
    public SitioWebController(SitioWebService sitioWebService) {
        this.sitioWebService = sitioWebService;
    }

    @PostMapping
    public void save(@RequestBody final SitioWeb sitioWeb) {
        sitioWebService.save(sitioWeb);
    }

    @GetMapping
    public Iterable<SitioWeb> obtenerSitiosWeb() {
        return sitioWebService.obtenerTodos();
    }

    @GetMapping("/{sitio}")
    public Iterable<SitioWeb> obtenerSitioWeb(@PathVariable final String sitio) {
        return sitioWebService.obtenerSitio(sitio);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarSitioWeb(@PathVariable final String id) {
        sitioWebService.eliminarSitio(id);
    }
    
    
}
