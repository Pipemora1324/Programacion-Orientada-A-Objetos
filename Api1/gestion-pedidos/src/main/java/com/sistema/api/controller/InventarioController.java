package com.sistema.api.controller;

import com.sistema.api.model.InventarioModel;
import com.sistema.api.repository.InventarioRepository;
import com.sistema.api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioRepository inventarioRepository;
    
    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping("/cargar")
    public String cargarStock(@RequestParam int productoId, @RequestParam int cantidad) {
        InventarioModel inv = new InventarioModel();
        // Buscamos el producto que ya creaste antes
        inv.setProducto(productoRepository.findById(productoId).orElse(null));
        inv.setStock(cantidad);
        inventarioRepository.save(inv);
        return "Inventario cargado: " + cantidad + " unidades.";
    }
}