package com.mromoc1.Spring_demo2.repositories;

import java.util.ArrayList;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mromoc1.Spring_demo2.models.SitioWeb;

public interface SitioWebRepository extends ElasticsearchRepository<SitioWeb, String>{
    public abstract ArrayList<SitioWeb> findBySitio(String sitio);
}
