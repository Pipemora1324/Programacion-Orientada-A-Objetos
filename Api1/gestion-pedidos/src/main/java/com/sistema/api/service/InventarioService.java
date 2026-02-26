package com.sistema.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.api.repository.InventarioRepository;
import com.sistema.api.model.InventarioModel;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public boolean hayStock(int productoId, int cantidad) {
        // Buscamos el registro de inventario para ese producto
        return inventarioRepository.findAll().stream()
            .filter(i -> i.getProducto().getIdProducto() == productoId)
            .anyMatch(i -> i.getStock() >= cantidad);
    }

    public void descontar(int productoId, int cantidad) {
        InventarioModel inv = inventarioRepository.findAll().stream()
            .filter(i -> i.getProducto().getIdProducto() == productoId)
            .findFirst().orElse(null);
        
        if (inv != null) {
            inv.setStock(inv.getStock() - cantidad);
            inventarioRepository.save(inv); // Guardamos el nuevo stock
        }
    }
}