package co.edu.ucc.pasto.gestion_pedidos2.repository;

import co.edu.ucc.pasto.gestion_pedidos2.model.DetallePedido;
import co.edu.ucc.pasto.gestion_pedidos2.model.Pedido;
import co.edu.ucc.pasto.gestion_pedidos2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    List<DetallePedido> findByPedido(Pedido pedido);
    List<DetallePedido> findByProducto(Producto producto);
}