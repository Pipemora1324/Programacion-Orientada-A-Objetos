package co.edu.ucc.pasto.gestion_pedidos2.dto;

import lombok.Data;

@Data
public class AgregarProductoDTO {
    private Long idProducto; // Cambiado a Long para que cuadre con el modelo
    private Integer cantidad;
}   

