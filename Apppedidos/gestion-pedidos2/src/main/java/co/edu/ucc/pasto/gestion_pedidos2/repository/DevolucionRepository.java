package co.edu.ucc.pasto.gestion_pedidos2.repository;

import co.edu.ucc.pasto.gestion_pedidos2.model.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucionRepository extends JpaRepository<Devolucion, Long> {
}