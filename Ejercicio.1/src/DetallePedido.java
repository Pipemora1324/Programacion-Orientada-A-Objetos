// ========================================
// CLASE: DetallePedido
// ========================================
// Representa una linea dentro de un pedido.
// Por ejemplo: "3 unidades de Camiseta a $25.000 c/u = $75.000"
//
// RELACIONES en el diagrama:
//   - Pedido (1) ---<>--- (1..*) DetallePedido
//     La "composicion" (rombo negro) significa que DetallePedido
//     ES PARTE DE Pedido. Si el pedido se elimina, los detalles tambien.
//     Un pedido tiene 1 o mas detalles (1..*).
//   - DetallePedido (*) ---- (1) Producto
//     Muchos detalles pueden apuntar al mismo producto,
//     pero cada detalle solo tiene 1 producto.
// ========================================

public class DetallePedido {

    // -- ATRIBUTOS --
    private int cantidad;        // Cuantas unidades del producto
    private Producto producto;   // Cual es el producto (referencia a objeto Producto)
    private double subtotal;     // cantidad * precio del producto

    // -- CONSTRUCTOR --
    // En el diagrama: +DetallePedido(producto, cantidad)
    public DetallePedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        // Calculamos el subtotal apenas se crea el detalle
        calcularSubTotal();
    }

    // -- METODOS --

    // Calcula el subtotal de este detalle (cantidad x precio)
    // En el diagrama: +calcularSupTotal() : void
    public void calcularSubTotal() {
        this.subtotal = cantidad * producto.getPrecio();
    }

    // Retorna el subtotal calculado
    // En el diagrama: +getSuptotal() : double
    public double getSuptotal() {
        return subtotal;
    }

    // Retorna el producto de este detalle
    // En el diagrama: +getProducto() : producto
    public Producto getProducto() {
        return producto;
    }

    // Retorna la cantidad
    // En el diagrama: +getCantidad() : int
    public int getCantidad() {
        return cantidad;
    }

    // Para mostrar el detalle bonito al imprimir
    @Override
    public String toString() {
        return "  - " + producto.getNombre() + 
               " x" + cantidad + 
               " = $" + subtotal;
    }
}