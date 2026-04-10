package co.edu.ucc.pasto.gestion_pedidos2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private Double precio; // Precio total (Con IVA)
    private Double precioSinIva; // Base grabable
    private Double valorIva; // El 19% calculado
    private Integer stock;
}