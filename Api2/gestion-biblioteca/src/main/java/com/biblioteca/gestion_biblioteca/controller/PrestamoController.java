package com.biblioteca.gestion_biblioteca.controller;

import com.biblioteca.gestion_biblioteca.model.Prestamo;
import com.biblioteca.gestion_biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/prestar")
    public Prestamo prestarLibro(@RequestBody Prestamo prestamo) {
        // Aquí recibimos el JSON con los IDs del libro y usuario
        return prestamoService.prestarLibro(prestamo);
    }

    @PostMapping("/devolver/{id}")
    public void devolverLibro(@PathVariable Long id) {
        prestamoService.devolverLibro(id);
    }
}