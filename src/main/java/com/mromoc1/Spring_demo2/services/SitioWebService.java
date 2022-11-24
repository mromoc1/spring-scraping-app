package com.mromoc1.Spring_demo2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mromoc1.Spring_demo2.models.SitioWeb;
import com.mromoc1.Spring_demo2.repositories.SitioWebRepository;

@Service
public class SitioWebService {
    private final SitioWebRepository sitioWebRepository;

    @Autowired
    public SitioWebService(SitioWebRepository sitioWebRepository) {
        this.sitioWebRepository = sitioWebRepository;
    }

    public void save(SitioWeb sitioWeb) {
        sitioWebRepository.save(sitioWeb);
    }

    public Iterable<SitioWeb> obtenerSitio(String sitio){
        return sitioWebRepository.findBySitio(sitio);
    }

    public Iterable<SitioWeb> obtenerTodos(){
        return sitioWebRepository.findAll();
    }

    public void eliminarSitio(String id){
        sitioWebRepository.deleteById(id);
    }
}
