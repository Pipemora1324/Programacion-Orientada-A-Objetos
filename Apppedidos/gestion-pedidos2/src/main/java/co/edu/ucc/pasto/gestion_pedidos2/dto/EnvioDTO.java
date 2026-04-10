package co.edu.ucc.pasto.gestion_pedidos2.dto;

import lombok.Data;

@Data
public class EnvioDTO {
    private Long idPedido;
    private String direccion;
    private String transportadora;
}