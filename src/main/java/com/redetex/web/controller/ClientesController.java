package com.redetex.web.controller;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/buscar")
    public List<Cliente> buscarTodosClientes() {
        return clienteService.listarTodosClientes();
    }

    @GetMapping(value = "/buscar/{idCliente}")
    public Cliente buscarCliente(@PathVariable Long idCliente) {
        return clienteService.listarCliente(idCliente);
    }

    @PostMapping(value = "/salvar")
    public void salvarCliente(@RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
    }

    @GetMapping(value = "/cancelar/{idCliente}")
    public void cancelarCliente(@PathVariable Long idCliente) {
        clienteService.cancelarCliente(idCliente);
    }
}
