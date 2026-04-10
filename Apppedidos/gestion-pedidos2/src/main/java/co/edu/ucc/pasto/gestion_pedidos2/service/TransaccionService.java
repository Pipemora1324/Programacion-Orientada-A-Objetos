package co.edu.ucc.pasto.gestion_pedidos2.service;

import co.edu.ucc.pasto.gestion_pedidos2.model.*;
import co.edu.ucc.pasto.gestion_pedidos2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
    @Autowired private TransaccionRepository transaccionRepository;
    @Autowired private PedidoRepository pedidoRepository;

    public Transaccion realizarPago(Long idPedido, Double monto, MetodoPago metodo) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido == null) return null;

        Transaccion t = new Transaccion();
        t.setPedido(pedido);
        t.setMonto(monto);
        t.setEstado(EstadoPedido.PAGADO); // Actualizamos el estado
        return transaccionRepository.save(t);
    }
}