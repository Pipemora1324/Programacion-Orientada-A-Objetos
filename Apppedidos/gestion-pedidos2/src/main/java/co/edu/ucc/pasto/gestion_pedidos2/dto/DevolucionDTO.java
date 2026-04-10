package co.edu.ucc.pasto.gestion_pedidos2.dto;

import lombok.Data;

@Data
public class DevolucionDTO {
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
    private String motivo;
}