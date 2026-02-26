package com.sistema.api.controller;

import com.sistema.api.model.ProductoModel;
import com.sistema.api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping("/guardar")
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/listar")
    public List<ProductoModel> listar() {
        return productoRepository.findAll();
    }
}