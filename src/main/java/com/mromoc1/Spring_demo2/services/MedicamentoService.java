package com.mromoc1.Spring_demo2.services;

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
        medicamentoRepository.save(medicamento);
    }

    public Iterable<Medicamento> obtenerMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public Iterable<Medicamento> obtenerMedicamentoPorNombre(String nombre) {
        return medicamentoRepository.findByNombre(nombre);
    }

    public void eliminarMedicamento(String id) {
        medicamentoRepository.deleteById(id);
    }
    
}
