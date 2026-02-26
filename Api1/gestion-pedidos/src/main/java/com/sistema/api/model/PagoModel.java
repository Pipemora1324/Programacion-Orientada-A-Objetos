package com.sistema.api.model;

import jakarta.persistence.*;
import lombok.Data;
import com.sistema.api.model.ENUMSModel.*;

@Entity @Data
public class PagoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Enumerated(EnumType.STRING)
    private MetodoPago metodo;
    
    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    public EstadoPago getEstado() { return estado; }
}