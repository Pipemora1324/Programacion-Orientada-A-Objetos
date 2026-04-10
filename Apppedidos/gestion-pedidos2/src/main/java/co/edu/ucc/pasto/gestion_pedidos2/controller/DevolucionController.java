package co.edu.ucc.pasto.gestion_pedidos2.controller;

import co.edu.ucc.pasto.gestion_pedidos2.model.Devolucion;
import co.edu.ucc.pasto.gestion_pedidos2.service.DevolucionService;
import co.edu.ucc.pasto.gestion_pedidos2.dto.DevolucionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    @PostMapping
    public ResponseEntity<Devolucion> crear(@RequestBody DevolucionDTO dto) {
        return ResponseEntity.ok(devolucionService.procesarDevolucion(
            dto.getIdPedido(), dto.getIdProducto(), dto.getCantidad(), dto.getMotivo()
        ));
    }
}