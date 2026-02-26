// ========================================
// CLASE: Main (clase principal)
// ========================================
// Esta clase NO aparece en el diagrama UML porque
// es solo el punto de entrada del programa.
// Aqui probamos que todo funciona correctamente.
//
// Para ejecutar: javac src/*.java -d bin && java -cp bin Main
// ========================================

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE PEDIDOS ===\n");

        // -----------------------------------------------
        // PASO 1: Crear productos
        // -----------------------------------------------
        System.out.println("--- Creando productos ---");
        Producto camiseta = new Producto(1, "Camiseta", 25000);
        Producto pantalon = new Producto(2, "Pantalon", 60000);
        Producto zapatos  = new Producto(3, "Zapatos",  90000);

        System.out.println("Productos creados:");
        System.out.println(camiseta);
        System.out.println(pantalon);
        System.out.println(zapatos);

        // -----------------------------------------------
        // PASO 2: Crear inventarios para cada producto
        // Relacion Inventario (1) ---- (1) Producto
        // -----------------------------------------------
        System.out.println("\n--- Creando inventarios ---");
        Inventario invCamiseta = new Inventario(camiseta, 10);  // 10 camisetas disponibles
        Inventario invPantalon = new Inventario(pantalon, 5);   // 5 pantalones disponibles
        Inventario invZapatos  = new Inventario(zapatos,  3);   // 3 pares de zapatos

        invCamiseta.mostrarStock();
        invPantalon.mostrarStock();
        invZapatos.mostrarStock();

        // -----------------------------------------------
        // PASO 3: Crear un cliente
        // -----------------------------------------------
        System.out.println("\n--- Creando cliente ---");
        Cliente cliente1 = new Cliente(101, "Juan Perez", "juan@correo.com");
        System.out.println(cliente1);

        // -----------------------------------------------
        // PASO 4: El cliente crea un pedido
        // Relacion: Cliente (1) ---- (0..*) Pedido
        // -----------------------------------------------
        System.out.println("\n--- Creando pedido ---");
        Pedido pedido1 = cliente1.crearPedido();

        // -----------------------------------------------
        // PASO 5: Agregar productos al pedido
        // Relacion: Pedido ---<>--- DetallePedido (composicion)
        // Cada producto agregado crea un DetallePedido
        // y descuenta del inventario
        // -----------------------------------------------
        System.out.println("\n--- Agregando productos al pedido ---");
        pedido1.agregarProducto(camiseta, 2, invCamiseta);  // 2 camisetas
        pedido1.agregarProducto(pantalon, 1, invPantalon);  // 1 pantalon
        pedido1.agregarProducto(zapatos,  1, invZapatos);   // 1 par de zapatos

        // Intentamos pedir mas de lo que hay en stock
        System.out.println("\n--- Intentando pedir mas stock del disponible ---");
        pedido1.agregarProducto(zapatos, 10, invZapatos);   // Deberia fallar

        // -----------------------------------------------
        // PASO 6: Ver resumen antes de pagar
        // -----------------------------------------------
        pedido1.mostrarResumen();

        // -----------------------------------------------
        // PASO 7: Pagar el pedido
        // Relacion: Pedido (1) ---- (1) Pago
        // Pedido <<use>> MetodoPago
        // -----------------------------------------------
        System.out.println("--- Pagando el pedido ---");
        pedido1.pagar(MetodoPago.PSE);  // Pagamos con PSE

        // -----------------------------------------------
        // PASO 8: Ver resumen final con pago incluido
        // -----------------------------------------------
        pedido1.mostrarResumen();

        // -----------------------------------------------
        // PASO 9: Ver inventario final
        // -----------------------------------------------
        System.out.println("--- Stock final despues del pedido ---");
        invCamiseta.mostrarStock();
        invPantalon.mostrarStock();
        invZapatos.mostrarStock();

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}