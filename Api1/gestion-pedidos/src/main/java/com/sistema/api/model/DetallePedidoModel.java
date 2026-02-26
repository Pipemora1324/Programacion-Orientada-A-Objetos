package com.sistema.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class DetallePedidoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    private double subtotal;

    @ManyToOne
    private ProductoModel producto;

    public ProductoModel getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }
}