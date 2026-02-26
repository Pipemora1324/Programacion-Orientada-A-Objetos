package com.sistema.api.controller;

import com.sistema.api.model.ENUMSModel.MetodoPago;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @PostMapping("/pagar")
    public void pagar(@RequestParam MetodoPago metodo) {
    }

    @PostMapping("/procesar")
    public void procesarPago() {
    }
}