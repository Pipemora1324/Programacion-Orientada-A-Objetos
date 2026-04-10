package co.edu.ucc.pasto.gestion_pedidos2.service;

import co.edu.ucc.pasto.gestion_pedidos2.dto.PedidoDTO;
import co.edu.ucc.pasto.gestion_pedidos2.exception.ResourceNotFoundException;
import co.edu.ucc.pasto.gestion_pedidos2.model.Cliente;
import co.edu.ucc.pasto.gestion_pedidos2.model.EstadoPedido;
import co.edu.ucc.pasto.gestion_pedidos2.model.Pedido;
import co.edu.ucc.pasto.gestion_pedidos2.model.Producto;
import co.edu.ucc.pasto.gestion_pedidos2.repository.ClienteRepository;
import co.edu.ucc.pasto.gestion_pedidos2.repository.PedidoRepository;
import co.edu.ucc.pasto.gestion_pedidos2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired private PedidoRepository pedidoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private ProductoRepository productoRepository;

    @Transactional
    public Pedido crearPedido(PedidoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + dto.getIdCliente()));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setNombreCliente(cliente.getNombre());
        pedido.setEstado(EstadoPedido.CREADO);
        pedido.setTotal(0.0);
        pedido.setFechaCreacion(LocalDateTime.now());

        return pedidoRepository.save(pedido);
    }

    @Transactional
    public Pedido agregarProducto(Long idPedido, Long idProducto, Integer cantidad) {
        Pedido pedido = pedidoRepository.findById(idPedido)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        Producto producto = productoRepository.findById(idProducto)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        if (producto.getStock() < cantidad) {
            throw new ResourceNotFoundException("Stock insuficiente para el producto con id: " + idProducto);
        }

        pedido.setTotal(pedido.getTotal() + (producto.getPrecio() * cantidad));
        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
