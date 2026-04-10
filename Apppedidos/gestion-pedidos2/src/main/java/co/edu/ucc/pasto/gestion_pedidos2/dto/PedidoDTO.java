package co.edu.ucc.pasto.gestion_pedidos2.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoDTO {
    private Long idCliente;
    private List<DetallePedidoDTO> productos;
}