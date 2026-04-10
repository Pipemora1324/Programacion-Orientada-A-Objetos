package co.edu.ucc.pasto.gestion_pedidos2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    
    private Date fecha;
    private double total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles;
    
    public Long getIdPedido() {
        return idPedido;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public EstadoPedido getEstado() {
        return estado;
    }
    
    public double getTotal() {
        return total;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public List<DetallePedido> getDetalles() {
        return detalles;
    }
}