package com.sistema.api.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.sistema.api.repository.PedidoRepository;
import com.sistema.api.model.PedidoModel;
import com.sistema.api.model.ClienteModel;
import com.sistema.api.model.ProductoModel;
import com.sistema.api.model.InventarioModel;
import com.sistema.api.model.ENUMSModel;
import java.util.ArrayList;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private InventarioService inventarioService;

    public PedidoModel crearPedido(ClienteModel cliente) {
        PedidoModel nuevoPedido = new PedidoModel();
        nuevoPedido.setCliente(cliente);
        nuevoPedido.setEstado(ENUMSModel.EstadoPedido.CREADO);
        nuevoPedido.setDetalles(new ArrayList<>());
        return pedidoRepository.save(nuevoPedido);
    }

    public String agregarProducto(int pedidoId, int productoId, int cantidad) {
        if (inventarioService.hayStock(productoId, cantidad)) {
            inventarioService.descontar(productoId, cantidad);
            return "Producto agregado y stock descontado";
        } else {
            return "Error: No hay suficiente stock";
        }
    }
}