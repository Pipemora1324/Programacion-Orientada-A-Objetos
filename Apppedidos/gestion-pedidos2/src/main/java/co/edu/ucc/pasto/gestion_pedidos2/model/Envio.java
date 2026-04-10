package co.edu.ucc.pasto.gestion_pedidos2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
@Data // <-- ESTO genera automáticamente los setters que te dan error
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private String transportadora;
    private String numeroGuia;
    private LocalDateTime fechaEnvio;

    @OneToOne
    @JoinColumn(name = "pedido_id", unique = true)
    private Pedido pedido;
}