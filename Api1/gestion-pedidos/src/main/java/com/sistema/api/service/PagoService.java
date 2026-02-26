package com.sistema.api.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.sistema.api.repository.PagoRepository;
import com.sistema.api.model.ENUMSModel.MetodoPago;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public void procesarPago(MetodoPago metodo) {
        System.out.println("Procesando pago con: " + metodo);
        // Aquí podrías usar pagoRepository.save(...) más adelante
    }
}