package com.mromoc1.Spring_demo2.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mromoc1.Spring_demo2.models.Medicamento;
import com.mromoc1.Spring_demo2.services.MedicamentoService;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {
    private final MedicamentoService medicamentoService;
    private static final Logger log = LoggerFactory.getLogger(MedicamentoController.class);

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public void save(@RequestBody final Medicamento medicamento) {
        try {
            log.info("POST|202|"+medicamento.getNombre());
            medicamentoService.save(medicamento);
            log.info("POST|200|"+medicamento.getNombre());
        } catch (Exception e) {
            log.error("POST|400|"+e.getMessage());
        }
    }

    @GetMapping("/{nombre}")
    public Iterable<Medicamento> obtenerMedicamentoPorNombre(@PathVariable final String nombre) {
        try {
            log.info("GET|202|"+nombre);
            Iterable<Medicamento> var = medicamentoService.obtenerMedicamentoPorNombre(nombre);
            log.info("GET|200|"+nombre);
            return var;
        } catch (Exception e) {
            log.error("GET|400|"+e.getMessage());
            return null;
        }
    }

    @GetMapping
    public Iterable<Medicamento> obtenerMedicamentos() {
        try {
            log.info("GET|202");
            Iterable<Medicamento> var = medicamentoService.obtenerMedicamentos();
            log.info("GET|200");
            return var;
        } catch (Exception e) {
            log.error("GET|400|"+e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarMedicamento(@PathVariable final String id) {
        try {
            log.info("DELETE|202|"+id);
            medicamentoService.eliminarMedicamento(id);
            log.info("DELETE|200|"+id);
        } catch (Exception e) {
            log.error("DELETE|400|"+e.getMessage());
        }
    }
}
