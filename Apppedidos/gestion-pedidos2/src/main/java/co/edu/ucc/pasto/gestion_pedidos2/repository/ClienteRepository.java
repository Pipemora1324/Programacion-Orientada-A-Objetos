package co.edu.ucc.pasto.gestion_pedidos2.repository;

import co.edu.ucc.pasto.gestion_pedidos2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCorreo(String correo);
    Optional<Cliente> findByNombre(String nombre);
}