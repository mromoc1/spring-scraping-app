package com.mromoc1.Spring_demo2.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mromoc1.Spring_demo2.models.Medicamento;
import com.mromoc1.Spring_demo2.repositories.MedicamentoRepository;

@Service
public class MedicamentoService {
    // medicamentoRepository nos permite hacer las operaciones CRUD con la base de datos de Elasticsearch 
    // utilizando el modelo Medicamento que creamos anteriormente
    // nos facilita mucho el trabajo ya que no tenemos que escribir las consultas a la base de datos nosotros mismos 
    // sino que podemos utilizar los métodos que nos proporciona el repositorio de Spring Data Elasticsearch 
    private final MedicamentoRepository medicamentoRepository;
    private static final Logger log = LoggerFactory.getLogger(MedicamentoService.class);
    
    @Autowired
    // inyectamos el repositorio de medicamentos en el constructor de la clase 
    // nos permite utilizar los métodos del repositorio en la clase
    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
            this.medicamentoRepository = medicamentoRepository;
    }

    // save es un método que nos proporciona el repositorio de Spring Data Elasticsearch
    // nos permite guardar un medicamento en la base de datos de Elasticsearch
    // lo guarda como un documento en la base de datos
    // podemos acceder a el utilizando el id que le hemos asignado al medicamento
    // para poder acceder por medio de nombre o descripción tendríamos que crear un índice
    // que nos permita hacer búsquedas por esos campos
    public void save(Medicamento medicamento) {
        try {
            medicamentoRepository.save(medicamento);
        } catch (Exception e) {
            log.error("ERROR|400|"+e.getMessage());
        }
    }

    public Iterable<Medicamento> obtenerMedicamentos() {
        try {
            Iterable<Medicamento> var = medicamentoRepository.findAll();
            return var;
        } catch (Exception e) {
            log.error("ERROR|400|"+e.getMessage());
            return null;
        }
    }

    public Iterable<Medicamento> obtenerMedicamentoPorNombre(String nombre) {
        try {
            Iterable<Medicamento> var = medicamentoRepository.findByNombre(nombre);
            return var;
        } catch (Exception e) {
            log.error("ERROR|400|"+e.getMessage());
            return null;
        }
    }

    public void eliminarMedicamento(String id) {
        try {
            medicamentoRepository.deleteById(id);
        } catch (Exception e) {
            log.error("ERROR|400|"+e.getMessage());
        }
    }
    
}
