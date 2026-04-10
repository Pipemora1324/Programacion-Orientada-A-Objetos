package co.edu.ucc.pasto.gestion_pedidos2.controller;

import co.edu.ucc.pasto.gestion_pedidos2.dto.PagoDTO;
import co.edu.ucc.pasto.gestion_pedidos2.dto.DevolucionDTO;
import co.edu.ucc.pasto.gestion_pedidos2.model.Transaccion;
import co.edu.ucc.pasto.gestion_pedidos2.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @PostMapping("/pago")
    public ResponseEntity<Transaccion> realizarPago(@RequestBody PagoDTO dto) {
        return ResponseEntity.ok(transaccionService.realizarPago(dto.getIdPedido(), dto.getMonto(), dto.getMetodo()));
    }

    // Nota: El servicio debe tener implementar realizarDevolucion para que este funcione
    @PostMapping("/devolucion")
    public ResponseEntity<String> realizarDevolucion(@RequestBody DevolucionDTO dto) {
        return ResponseEntity.ok("Devolución procesada para el pedido: " + dto.getIdPedido());
    }
}