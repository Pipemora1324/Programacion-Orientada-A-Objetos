package com.sistema.api.model;

public class ENUMSModel {
    public enum EstadoPedido { CREADO, PAGADO, ENVIADO, CANCELADO }
    public enum EstadoPago { PENDIENTE, APROBADO, RECHAZADO }
    public enum MetodoPago { TARJETA, PSE, EFECTIVO }
}