package co.edu.ucc.pasto.gestion_pedidos2.repository;

import co.edu.ucc.pasto.gestion_pedidos2.model.Pedido;
import co.edu.ucc.pasto.gestion_pedidos2.model.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
    List<Pedido> findByEstado(EstadoPedido estado);
}