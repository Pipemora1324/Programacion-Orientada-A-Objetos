package com.sistema.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class ProductoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String nombre;
    private double precio;

    public double getPrecio() { return precio; }
    public String getNombre() { return nombre; }
}