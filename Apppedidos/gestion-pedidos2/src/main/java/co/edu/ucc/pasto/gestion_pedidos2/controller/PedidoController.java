package co.edu.ucc.pasto.gestion_pedidos2.controller;

import co.edu.ucc.pasto.gestion_pedidos2.model.Pedido;
import co.edu.ucc.pasto.gestion_pedidos2.service.PedidoService;
import co.edu.ucc.pasto.gestion_pedidos2.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody PedidoDTO dto) {
        return ResponseEntity.ok(pedidoService.crearPedido(dto));
    }
}