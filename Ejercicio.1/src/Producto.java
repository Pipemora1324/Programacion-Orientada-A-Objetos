// ========================================
// CLASE: Producto
// ========================================
// Representa un producto que se puede vender.
//
// RELACIONES en el diagrama:
//   - Producto (1) ---- (*) DetallePedido
//     Un producto puede estar en muchos detalles de pedido
//     (muchas veces vendido), pero cada detalle tiene 1 producto.
//   - Producto (1) ---- (1) Inventario
//     Cada producto tiene un inventario asociado.
//
// Los atributos con "-" son PRIVADOS (private)
// Los metodos con "+" son PUBLICOS (public)
// ========================================

public class Producto {

    // -- ATRIBUTOS (private = solo accesibles dentro de esta clase) --
    private int idProducto;      // Identificador unico del producto
    private String nombre;       // Nombre del producto
    private double precio;       // Precio del producto

    // -- CONSTRUCTOR --
    // El constructor se llama igual que la clase.
    // En el diagrama aparece como: +producto(idProducto, nombre, precio)
    public Producto(int idProducto, String nombre, double precio) {
        this.idProducto = idProducto;  // "this" se refiere al objeto actual
        this.nombre = nombre;
        this.precio = precio;
    }

    // -- METODOS (getters: para obtener los valores privados desde afuera) --

    // Retorna el precio del producto
    // En el diagrama: +getPrecio() : double
    public double getPrecio() {
        return precio;
    }

    // Retorna el nombre del producto
    // En el diagrama: +getNombre() : String
    public String getNombre() {
        return nombre;
    }

    // Retorna el id del producto (agregado para poder usarlo)
    public int getIdProducto() {
        return idProducto;
    }

    // Muestra el producto como texto legible
    // En el diagrama: +toString() : String
    @Override
    public String toString() {
        return "Producto [ID=" + idProducto + ", Nombre=" + nombre + ", Precio=$" + precio + "]";
    }
}