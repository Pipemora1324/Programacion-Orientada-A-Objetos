// ========================================
// CLASE: Inventario
// ========================================
// Controla el stock (cantidad disponible) de un producto.
//
// RELACIONES en el diagrama:
//   - Inventario (1) ---- (1) Producto
//     Cada inventario pertenece a un solo producto.
//   - Pedido usa Inventario (a traves del metodo agregarProducto)
//     Cuando se agrega un producto al pedido, se descuenta del inventario.
// ========================================

public class Inventario {

    // -- ATRIBUTOS --
    private Producto producto;  // El producto al que pertenece este inventario
    private int stock;          // Cantidad disponible en inventario

    // -- CONSTRUCTOR --
    // En el diagrama: +Inventario(producto, stock)
    public Inventario(Producto producto, int stock) {
        this.producto = producto;
        this.stock = stock;
    }

    // -- METODOS --

    // Verifica si hay suficiente stock para una cantidad pedida
    // En el diagrama: +hayStock(cantidad : int) : boolean
    public boolean hayStock(int cantidad) {
        return stock >= cantidad;  // Retorna true si hay suficiente stock
    }

    // Descuenta del stock cuando se hace un pedido
    // En el diagrama: +descontar(cantidad : int) : void
    public void descontar(int cantidad) {
        if (hayStock(cantidad)) {
            stock -= cantidad;  // Restamos la cantidad al stock
            System.out.println("Stock descontado. Stock restante: " + stock);
        } else {
            System.out.println("No hay suficiente stock para descontar.");
        }
    }

    // Agrega stock (cuando llega mercancia nueva)
    // En el diagrama: +agregar(cantidad : int) : void
    public void agregar(int cantidad) {
        stock += cantidad;
        System.out.println("Stock agregado. Stock total: " + stock);
    }

    // Muestra cuanto stock hay disponible
    // En el diagrama: +mostrarStock() : void
    public void mostrarStock() {
        System.out.println("Producto: " + producto.getNombre() + " | Stock disponible: " + stock);
    }

    // Getters
    public Producto getProducto() {
        return producto;
    }

    public int getStock() {
        return stock;
    }
}