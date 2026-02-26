// ========================================
// ENUMERACION: EstadoPago
// ========================================
// Representa los posibles estados de un pago.
// En el diagrama: PENDIENTE, APROBADO, RECHAZADO
// La clase Pago "usa" (<<use>>) este enum.
// Tambien hay una flecha de herencia desde EstadoPago
// hacia EstadoPedido en el diagrama (la flecha con triangulo)
// pero en realidad representan cosas distintas, asi que
// las dejamos separadas como enums independientes.
// ========================================

public enum EstadoPago {
    PENDIENTE,
    APROBADO,
    RECHAZADO
}