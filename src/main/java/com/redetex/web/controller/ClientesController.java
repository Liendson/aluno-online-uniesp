package com.redetex.web.controller;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.dto.ClienteDTO;
import com.redetex.web.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/buscar")
    public ResponseEntity<List<ClienteDTO>> buscarTodosClientes() {
        return new ResponseEntity<>(clienteService.listarTodosClientes(), HttpStatus.OK) ;
    }

    @GetMapping(value = "/buscar/{idCliente}")
    public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable Long idCliente) {
        return new ResponseEntity<>(clienteService.listarCliente(idCliente), HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<ClienteDTO> salvarCliente(@RequestBody ClienteDTO cliente) {
        return new ResponseEntity<>(clienteService.salvarCliente(cliente), HttpStatus.OK);
    }

    @GetMapping(value = "/cancelar/{idCliente}")
    public ResponseEntity<ClienteDTO> cancelarCliente(@PathVariable Long idCliente) {
        return new ResponseEntity<>(clienteService.cancelarCliente(idCliente), HttpStatus.OK);

    }
}
