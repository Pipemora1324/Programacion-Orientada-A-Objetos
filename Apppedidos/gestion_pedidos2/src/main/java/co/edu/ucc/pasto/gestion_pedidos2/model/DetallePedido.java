package co.edu.ucc.pasto.gestion_pedidos2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_pedidos")
@Getter
@Setter
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    
    private int cantidad;
    private double precioUnitario;
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public Long getIdDetalle() {
        return idDetalle;
    }
    
    public Producto getProducto() {
        return producto;
    }
}