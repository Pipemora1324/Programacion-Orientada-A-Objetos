// ========================================
// CLASE: Cliente
// ========================================
// Representa a la persona que hace pedidos.
//
// RELACIONES en el diagrama:
//   - Cliente (1) ---- (0..*) Pedido
//     Un cliente puede tener ninguno o muchos pedidos (0..*).
//     Pero cada pedido pertenece a un solo cliente (1).
//     Esta es una relacion de ASOCIACION simple (linea sin rombo).
// ========================================

public class Cliente {

    // -- ATRIBUTOS (todos privados, con el "-" del diagrama) --
    private int idCliente;          // Identificador unico del cliente
    private String nombreCliente;   // Nombre completo
    private String correo;          // Correo electronico

    // -- CONSTRUCTOR --
    // En el diagrama: +cliente(idCliente, nombre, correo)
    public Cliente(int idCliente, String nombre, String correo) {
        this.idCliente = idCliente;
        this.nombreCliente = nombre;
        this.correo = correo;
    }

    // -- METODOS --

    // Crea y retorna un nuevo pedido para este cliente
    // En el diagrama: +crearPedido() : Pedido
    public Pedido crearPedido() {
        // Creamos un pedido pasando "this" (este cliente) como propietario
        Pedido nuevoPedido = new Pedido(this);
        System.out.println("Pedido creado para el cliente: " + nombreCliente);
        return nuevoPedido;
    }

    // Retorna el nombre del cliente
    // En el diagrama: +getNombre() : string
    public String getNombre() {
        return nombreCliente;
    }

    // Getters adicionales
    public int getIdCliente() {
        return idCliente;
    }

    public String getCorreo() {
        return correo;
    }

    // Muestra el cliente como texto
    // En el diagrama: +toString() : String
    @Override
    public String toString() {
        return "Cliente [ID=" + idCliente + ", Nombre=" + nombreCliente + ", Correo=" + correo + "]";
    }
}