package co.edu.ucc.pasto.gestion_pedidos2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transacciones")
@Getter
@Setter
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;
    
    private double monto;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    @Enumerated(EnumType.STRING)
    private EstadoTransaccion estado;
    
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }
}