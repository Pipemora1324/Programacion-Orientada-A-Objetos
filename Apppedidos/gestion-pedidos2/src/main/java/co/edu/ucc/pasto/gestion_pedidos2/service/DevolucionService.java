package co.edu.ucc.pasto.gestion_pedidos2.service;

import co.edu.ucc.pasto.gestion_pedidos2.model.*;
import co.edu.ucc.pasto.gestion_pedidos2.repository.*;
import co.edu.ucc.pasto.gestion_pedidos2.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class DevolucionService {

    @Autowired private DevolucionRepository devolucionRepository;
    @Autowired private PedidoRepository pedidoRepository;
    @Autowired private ProductoRepository productoRepository;

    @Transactional
    public Devolucion procesarDevolucion(Long idPedido, Long idProducto, Integer cantidad, String motivo) {
        Pedido pedido = pedidoRepository.findById(idPedido)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
            
        Producto producto = productoRepository.findById(idProducto)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        // 1. Crear el registro de devolución
        Devolucion dev = new Devolucion();
        dev.setPedido(pedido);
        dev.setProducto(producto);
        dev.setCantidadDevuelta(cantidad);
        dev.setMotivo(motivo);
        dev.setFechaDevolucion(LocalDateTime.now());

        // 2. IMPORTANTE: Devolver el stock al inventario
        producto.setStock(producto.getStock() + cantidad);
        productoRepository.save(producto);

        return devolucionRepository.save(dev);
    }
}