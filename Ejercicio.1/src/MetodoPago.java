// ========================================
// ENUMERACION: MetodoPago
// ========================================
// Un "enum" es una lista fija de opciones.
// En el diagrama aparece como una clase con
// los valores: TARJETA, PSE, EFECTIVO
// La relacion con Pedido es <<use>> (uso simple)
// ========================================

public enum MetodoPago {
    TARJETA,
    PSE,
    EFECTIVO
}