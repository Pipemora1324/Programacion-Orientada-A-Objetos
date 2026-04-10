package co.edu.ucc.pasto.gestion_pedidos2.repository;

import co.edu.ucc.pasto.gestion_pedidos2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findByNombre(String nombre);
}