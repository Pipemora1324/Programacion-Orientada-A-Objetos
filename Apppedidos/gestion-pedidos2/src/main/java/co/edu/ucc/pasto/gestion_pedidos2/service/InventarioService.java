package co.edu.ucc.pasto.gestion_pedidos2.service;

import co.edu.ucc.pasto.gestion_pedidos2.model.Producto;
import co.edu.ucc.pasto.gestion_pedidos2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {
    @Autowired
    private ProductoRepository productoRepository;

    public boolean hayStock(Long idProducto, Integer cantidad) {
        Producto p = productoRepository.findById(idProducto).orElse(null);
        return p != null && p.getStock() >= cantidad;
    }

    public void descontar(Long idProducto, Integer cantidad) {
        Producto p = productoRepository.findById(idProducto).orElse(null);
        if (p != null) {
            p.setStock(p.getStock() - cantidad);
            productoRepository.save(p);
        }
    }

    public Integer mostrarStock(Long idProducto) {
        return productoRepository.findById(idProducto)
                .map(Producto::getStock).orElse(0);
    }
}