package co.edu.ucc.pasto.gestion_pedidos2.service;

import co.edu.ucc.pasto.gestion_pedidos2.model.Producto;
import co.edu.ucc.pasto.gestion_pedidos2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        
        // Este es el precio final del producto, es decir, ya incluye IVA
        double precioTotal = producto.getPrecio();

        // Sacamos la base sin IVA dividiendo entre 1.19
      double precioSinIva = precioTotal / 1.19;

        // El valor del IVA es la diferencia entre el total y la base
        double valorIva = precioTotal - precioSinIva;

        // Guardamos en el objeto el precio sin IVA y el valor del IVA
       producto.setPrecioSinIva(Math.round(precioSinIva * 100.0) / 100.0);
       producto.setValorIva(Math.round(valorIva * 100.0) / 100.0);

        // Guardamos el producto ya con el valor del IVA calculado
        return productoRepository.save(producto);
    }
}
