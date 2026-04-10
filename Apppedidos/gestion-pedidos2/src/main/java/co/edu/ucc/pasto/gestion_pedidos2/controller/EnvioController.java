package co.edu.ucc.pasto.gestion_pedidos2.controller;

import co.edu.ucc.pasto.gestion_pedidos2.model.Envio;
import co.edu.ucc.pasto.gestion_pedidos2.service.EnvioService;
import co.edu.ucc.pasto.gestion_pedidos2.dto.EnvioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @PostMapping("/despachar")
    public ResponseEntity<Envio> crearEnvio(@RequestBody EnvioDTO dto) {
        return ResponseEntity.ok(envioService.despacharPedido(
            dto.getIdPedido(), 
            dto.getDireccion(), 
            dto.getTransportadora()
        ));
    }
}