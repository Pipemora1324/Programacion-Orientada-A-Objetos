package co.edu.ucc.pasto.gestion_pedidos2.controller;

import co.edu.ucc.pasto.gestion_pedidos2.model.Producto;
import co.edu.ucc.pasto.gestion_pedidos2.repository.ProductoRepository;
import co.edu.ucc.pasto.gestion_pedidos2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(productoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.crearProducto(producto));

    }
}
