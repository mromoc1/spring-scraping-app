package com.mromoc1.Spring_demo2.repositories;

import java.util.ArrayList;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mromoc1.Spring_demo2.models.Medicamento;

public interface MedicamentoRepository extends ElasticsearchRepository<Medicamento, String> {
    public abstract ArrayList<Medicamento> findByNombre(String nombre);
}
