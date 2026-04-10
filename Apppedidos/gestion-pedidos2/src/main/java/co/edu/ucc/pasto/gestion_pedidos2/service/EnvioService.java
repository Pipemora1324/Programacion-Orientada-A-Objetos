package co.edu.ucc.pasto.gestion_pedidos2.service;

import co.edu.ucc.pasto.gestion_pedidos2.model.*;
import co.edu.ucc.pasto.gestion_pedidos2.repository.*;
import co.edu.ucc.pasto.gestion_pedidos2.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EnvioService {

    @Autowired private EnvioRepository envioRepository;
    @Autowired private PedidoRepository pedidoRepository;

    public Envio despacharPedido(Long idPedido, String direccion, String transportadora) {
        Pedido pedido = pedidoRepository.findById(idPedido)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado para envío"));

        // Validar que el pedido esté PAGADO antes de enviar (Opcional pero pro)
        if (pedido.getEstado() != EstadoPedido.PAGADO) {
            // Aquí podrías lanzar una excepción si quieres ponerte estricto
        }

        Envio envio = new Envio();
        envio.setPedido(pedido);
        envio.setDireccion(direccion);
        envio.setTransportadora(transportadora);
        envio.setFechaEnvio(LocalDateTime.now());
        envio.setNumeroGuia(UUID.randomUUID().toString().substring(0, 8).toUpperCase()); // Guia aleatoria

        // Actualizamos el estado del pedido
        pedido.setEstado(EstadoPedido.ENVIADO);
        pedidoRepository.save(pedido);

        return envioRepository.save(envio);
    }
}