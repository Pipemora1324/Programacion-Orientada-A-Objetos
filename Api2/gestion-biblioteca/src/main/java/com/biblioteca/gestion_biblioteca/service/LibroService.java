package com.biblioteca.gestion_biblioteca.service;

import com.biblioteca.gestion_biblioteca.model.Libro;
import com.biblioteca.gestion_biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro registrarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro editarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void darDeBajaLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
}