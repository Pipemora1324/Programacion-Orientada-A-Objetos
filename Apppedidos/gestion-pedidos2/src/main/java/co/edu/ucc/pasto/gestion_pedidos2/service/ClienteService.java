package co.edu.ucc.pasto.gestion_pedidos2.service;

import co.edu.ucc.pasto.gestion_pedidos2.model.Cliente;
import co.edu.ucc.pasto.gestion_pedidos2.repository.ClienteRepository;
import co.edu.ucc.pasto.gestion_pedidos2.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(String nombre, String correo) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Este es el método que usa el controlador
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
    }
}