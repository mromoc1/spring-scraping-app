package com.mromoc1.Spring_demo2.controllers;

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

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public void save(@RequestBody final Medicamento medicamento) {
        medicamentoService.save(medicamento);
    }

    @GetMapping("/{nombre}")
    public Iterable<Medicamento> obtenerMedicamentoPorNombre(@PathVariable final String nombre) {
        return medicamentoService.obtenerMedicamentoPorNombre(nombre);
    }

    @GetMapping
    public Iterable<Medicamento> obtenerMedicamentos() {
        return medicamentoService.obtenerMedicamentos();
    }

    @DeleteMapping("/{id}")
    public void eliminarMedicamento(@PathVariable final String id) {
        medicamentoService.eliminarMedicamento(id);
    }

}
