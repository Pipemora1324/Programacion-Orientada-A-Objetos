package com.sistema.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class InventarioModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // ID técnico para la DB
    
    @OneToOne
    private ProductoModel producto;
    private int stock;
}