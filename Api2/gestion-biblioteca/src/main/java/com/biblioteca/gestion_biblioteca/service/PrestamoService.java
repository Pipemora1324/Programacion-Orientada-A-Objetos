package com.biblioteca.gestion_biblioteca.service;

import com.biblioteca.gestion_biblioteca.model.Prestamo;
import com.biblioteca.gestion_biblioteca.model.Libro;
import com.biblioteca.gestion_biblioteca.repository.PrestamoRepository;
import com.biblioteca.gestion_biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    public Prestamo prestarLibro(Prestamo prestamo) {
        // Marcamos el libro como NO disponible
        Libro libro = prestamo.getLibro();
        libro.setDisponible(false);
        libroRepository.save(libro);
        
        prestamo.setFechaPrestamo(LocalDate.now());
        return prestamoRepository.save(prestamo);
    }

    public void devolverLibro(Long idPrestamo) {
        Prestamo prestamo = prestamoRepository.findById(idPrestamo).orElse(null);
        if (prestamo != null) {
            // Volvemos a poner el libro disponible
            Libro libro = prestamo.getLibro();
            libro.setDisponible(true);
            libroRepository.save(libro);
            
            prestamo.setFechaDevolucion(LocalDate.now());
            prestamoRepository.save(prestamo);
        }
    }
}