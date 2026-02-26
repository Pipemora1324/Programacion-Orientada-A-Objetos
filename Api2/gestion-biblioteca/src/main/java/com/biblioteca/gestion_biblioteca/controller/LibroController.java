package com.biblioteca.gestion_biblioteca.controller;

import com.biblioteca.gestion_biblioteca.model.Libro;
import com.biblioteca.gestion_biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping("/crear")
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.registrarLibro(libro);
    }

    @GetMapping("/listar")
    public List<Libro> listarLibros() {
        return libroService.listarLibros();
    }

    @PutMapping("/editar")
    public Libro editarLibro(@RequestBody Libro libro) {
        return libroService.editarLibro(libro);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.darDeBajaLibro(id);
    }
}