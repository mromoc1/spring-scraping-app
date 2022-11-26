package com.mromoc1.Spring_demo2.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mromoc1.Spring_demo2.models.SitioWeb;
import com.mromoc1.Spring_demo2.repositories.SitioWebRepository;

@Service
public class SitioWebService {
    private final SitioWebRepository sitioWebRepository;
    private static final Logger log = LoggerFactory.getLogger(SitioWebRepository.class);

    @Autowired
    public SitioWebService(SitioWebRepository sitioWebRepository) {
        this.sitioWebRepository = sitioWebRepository;
    }

    public void save(SitioWeb sitioWeb) {
        try {
            sitioWebRepository.save(sitioWeb);
        } catch (Exception e) {
            log.error("ERROR|400|"+e.getMessage());
        }
    }

    public Iterable<SitioWeb> obtenerSitio(String sitio){
        try {
            return sitioWebRepository.findBySitio(sitio);
        } catch (Exception e) {
            log.error("ERROR|400|"+e.getMessage());
            return null;
        }
    }

    public Iterable<SitioWeb> obtenerTodos(){
        try {
            return sitioWebRepository.findAll();
        } catch (Exception e) {
            log.error("ERROR|400|"+e.getMessage());
            return null;
        }
    }

    public void eliminarSitio(String id){
        try {
            sitioWebRepository.deleteById(id);
        } catch (Exception e) {
            log.error("ERROR|400|"+e.getMessage());
        }
    }
}
