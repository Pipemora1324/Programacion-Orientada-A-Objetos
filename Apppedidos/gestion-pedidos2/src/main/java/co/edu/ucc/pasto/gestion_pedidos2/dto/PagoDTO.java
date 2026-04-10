package co.edu.ucc.pasto.gestion_pedidos2.dto;

import co.edu.ucc.pasto.gestion_pedidos2.model.MetodoPago; 
import lombok.Data;

@Data
public class PagoDTO {
    private Long idPedido;
    private Double monto;
    private MetodoPago metodo;
}