// ========================================
// CLASE: Pedido
// ========================================
// Es la clase CENTRAL del sistema. Agrupa todo.
//
// RELACIONES en el diagrama:
//   - Cliente (1) ---- (0..*) Pedido
//     Un cliente puede tener de 0 a muchos pedidos.
//   - Pedido (1) ---<>--- (1..*) DetallePedido  [COMPOSICION - rombo negro]
//     El pedido "tiene" los detalles. Son parte de el.
//     Si el pedido desaparece, los detalles tambien.
//   - Pedido (1) ---- (1) Pago
//     Cada pedido tiene exactamente un pago.
//   - Pedido <<use>> MetodoPago
//     Pedido usa el enum MetodoPago para hacer el pago.
//   - Pedido <<use>> EstadoPedido
//     Pedido usa el enum para saber en que estado esta.
// ========================================

import java.util.ArrayList;  // Necesitamos esto para usar listas dinamicas
import java.util.List;

public class Pedido {

    // -- ATRIBUTOS --
    // En el diagrama: -deatlles : List<DetallePedido>
    // (nota: "deatlles" es como aparece en el diagrama, aunque tiene typo)
    private List<DetallePedido> detalles;  // Lista de productos en el pedido

    // En el diagrama: -estado : EstadoPedido
    private EstadoPedido estado;           // Estado actual del pedido

    // En el diagrama: -total : double
    private double total;                  // Total a pagar

    // En el diagrama: -cliente : Cliente
    private Cliente cliente;               // A quien pertenece este pedido

    // En el diagrama: -pago : Pago
    private Pago pago;                     // El pago asociado

    // -- CONSTRUCTOR --
    // En el diagrama: +pedido(cliente : Cliente)
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.detalles = new ArrayList<>();  // Empezamos con una lista vacia
        this.estado = EstadoPedido.CREADO;  // Todo pedido empieza en estado CREADO
        this.total = 0;
    }

    // -- METODOS --

    // Agrega un producto al pedido (version simple)
    // En el diagrama: +agregarProducto()
    public void agregarProducto() {
        System.out.println("Usa el metodo agregarProducto(producto, cantidad, inventario) para agregar productos.");
    }

    // Agrega un producto con cantidad, verificando el inventario
    // En el diagrama: +agregarProducto(producto, cantidad, inventario) : void
    public void agregarProducto(Producto producto, int cantidad, Inventario inventario) {
        // Primero verificamos si hay suficiente stock
        if (inventario.hayStock(cantidad)) {
            // Creamos el detalle de pedido
            DetallePedido detalle = new DetallePedido(producto, cantidad);
            detalles.add(detalle);       // Lo agregamos a la lista
            inventario.descontar(cantidad); // Descontamos del inventario
            calcularTotal();             // Recalculamos el total
            System.out.println("Producto agregado: " + producto.getNombre() + " x" + cantidad);
        } else {
            System.out.println("No hay stock suficiente de: " + producto.getNombre());
        }
    }

    // Calcula el total sumando todos los subtotales de los detalles
    // En el diagrama: +calcularTotal() : double
    public double calcularTotal() {
        total = 0;
        // Recorremos cada detalle y sumamos su subtotal
        for (DetallePedido detalle : detalles) {
            total += detalle.getSuptotal();
        }
        return total;
    }

    // Realiza el pago del pedido con el metodo indicado
    // En el diagrama: +pagar(metodo : MetodoPago) : void
    public void pagar(MetodoPago metodo) {
        // Creamos el objeto Pago y lo procesamos
        this.pago = new Pago(metodo);
        pago.procesarPago();

        // Si el pago fue aprobado, cambiamos el estado del pedido
        if (pago.getEstado() == EstadoPago.APROBADO) {
            this.estado = EstadoPedido.PAGADO;
            System.out.println("Estado del pedido actualizado a: " + estado);
        }
    }

    // Muestra un resumen del pedido completo
    // En el diagrama: +mostrarResumen() : void
    public void mostrarResumen() {
        System.out.println("\n====== RESUMEN DEL PEDIDO ======");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Estado del pedido: " + estado);
        System.out.println("Productos:");
        for (DetallePedido detalle : detalles) {
            System.out.println(detalle);  // Llama al toString() de DetallePedido
        }
        System.out.println("TOTAL: $" + calcularTotal());
        if (pago != null) {
            System.out.println("Pago: " + pago);
        }
        System.out.println("================================\n");
    }

    // Getters
    public EstadoPedido getEstado() {
        return estado;
    }

    public double getTotal() {
        return total;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public Pago getPago() {
        return pago;
    }
}