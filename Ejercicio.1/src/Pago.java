// ========================================
// CLASE: Pago
// ========================================
// Representa el pago que se hace por un pedido.
//
// RELACIONES en el diagrama:
//   - Pedido (1) ---- (1) Pago
//     Un pedido tiene un pago, y ese pago es de un pedido.
//   - Pago <<use>> MetodoPago
//     Pago "usa" el enum MetodoPago para saber con que se pago.
//   - Pago <<use>> EstadoPago
//     Pago "usa" el enum EstadoPago para saber si fue aprobado, etc.
// ========================================

public class Pago {

    // -- ATRIBUTOS --
    private MetodoPago metodo;   // Con que se paga: TARJETA, PSE o EFECTIVO
    private EstadoPago estado;   // Como esta el pago: PENDIENTE, APROBADO o RECHAZADO

    // -- CONSTRUCTOR --
    // Cuando se crea un pago, empieza en estado PENDIENTE
    public Pago(MetodoPago metodo) {
        this.metodo = metodo;
        this.estado = EstadoPago.PENDIENTE;  // Por defecto empieza pendiente
    }

    // -- METODOS --

    // Procesa el pago (simula la aprobacion)
    // En el diagrama: +procesarPago() : void
    public void procesarPago() {
        System.out.println("Procesando pago con metodo: " + metodo);
        // Simulamos que siempre se aprueba (en la vida real aqui iria logica de banco, etc.)
        this.estado = EstadoPago.APROBADO;
        System.out.println("Pago APROBADO exitosamente!");
    }

    // Metodo alternativo que recibe el metodo (como en el diagrama: +pago(metodo))
    // En el diagrama: +pago(metodo)
    public void pago(MetodoPago metodo) {
        this.metodo = metodo;
        procesarPago();
    }

    // Retorna el estado actual del pago
    // En el diagrama: +getEstado() : EstadoPago
    public EstadoPago getEstado() {
        return estado;
    }

    // Getter del metodo de pago
    public MetodoPago getMetodo() {
        return metodo;
    }

    @Override
    public String toString() {
        return "Pago [Metodo=" + metodo + ", Estado=" + estado + "]";
    }
}