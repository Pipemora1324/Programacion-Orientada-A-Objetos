// ========================================
// ENUMERACION: EstadoPedido
// ========================================
// Representa los posibles estados de un pedido.
// En el diagrama: CREADO, PAGADO, ENVIADO, CANCELADO
// Pedido "usa" (<<use>>) este enum para saber en
// que estado esta el pedido en cada momento.
// ========================================

public enum EstadoPedido {
    CREADO,
    PAGADO,
    ENVIADO,
    CANCELADO
}