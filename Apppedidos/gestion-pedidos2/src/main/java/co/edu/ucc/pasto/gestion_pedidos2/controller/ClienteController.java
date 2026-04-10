package co.edu.ucc.pasto.gestion_pedidos2.controller;

import co.edu.ucc.pasto.gestion_pedidos2.model.Cliente;
import co.edu.ucc.pasto.gestion_pedidos2.service.ClienteService;
import co.edu.ucc.pasto.gestion_pedidos2.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes") // URL base
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    // Buscar por ID específico
    @GetMapping("/{id}") // El {id} debe coincidir con el @PathVariable
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.crearCliente(dto.getNombre(), dto.getCorreo()));
    }
}