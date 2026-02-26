package com.sistema.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.sistema.api.model.ENUMSModel.*;

@Entity @Data
public class PedidoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany
    private List<DetallePedidoModel> detalles;
    
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;
    
    private double total;

    @ManyToOne
    private ClienteModel cliente;

    @OneToOne
    private PagoModel pago;
}