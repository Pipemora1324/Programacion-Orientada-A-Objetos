package com.sistema.api.controller;

import com.sistema.api.model.PedidoModel;
import com.sistema.api.model.ClienteModel;
import com.sistema.api.service.PedidoService;
import com.sistema.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/generar/{idCliente}")
    public PedidoModel generarPedido(@PathVariable int idCliente) {
        // Buscamos al cliente en la DB
        ClienteModel cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        
        // El servicio crea el pedido y lo devuelve
        return pedidoService.crearPedido(cliente);
    }

    @PostMapping("/{idPedido}/agregar-producto")
    public String agregar(@PathVariable int idPedido, @RequestParam int productoId, @RequestParam int cantidad) {
        return pedidoService.agregarProducto(idPedido, productoId, cantidad);
    }
}