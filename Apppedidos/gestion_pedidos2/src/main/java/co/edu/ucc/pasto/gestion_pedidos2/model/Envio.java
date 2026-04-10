package co.edu.ucc.pasto.gestion_pedidos2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "envios")
@Getter
@Setter
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnvio;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    private double peso;
    private double volumen;
    
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
    
    public void setTipoEnvio(TipoEnvio tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }
}