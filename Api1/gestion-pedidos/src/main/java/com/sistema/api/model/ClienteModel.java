package com.sistema.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class ClienteModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nombreCliente;
    private String correo;

    public String getNombre() { return nombreCliente; }
    public String toString() { return nombreCliente; }
}