package com.sistema.api.controller;

import com.sistema.api.model.ClienteModel;
import com.sistema.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/guardar")
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/listar")
    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAll();
    }
}