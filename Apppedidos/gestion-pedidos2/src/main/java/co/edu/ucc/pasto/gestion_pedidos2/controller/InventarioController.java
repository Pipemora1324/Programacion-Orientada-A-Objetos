package co.edu.ucc.pasto.gestion_pedidos2.controller;

import co.edu.ucc.pasto.gestion_pedidos2.dto.StockDTO;
import co.edu.ucc.pasto.gestion_pedidos2.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/stock/{id}")
    public ResponseEntity<Integer> consultarStock(@PathVariable Long id) {
        return ResponseEntity.ok(inventarioService.mostrarStock(id));
    }

    @PostMapping("/verificar/{id}")
    public ResponseEntity<Boolean> verificarStock(@PathVariable Long id, @RequestParam Integer cantidad) {
        return ResponseEntity.ok(inventarioService.hayStock(id, cantidad));
    }
}