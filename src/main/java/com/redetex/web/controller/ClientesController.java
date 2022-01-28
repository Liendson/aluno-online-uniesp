package com.redetex.web.controller;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.dto.ClienteDTO;
import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.enums.TipoEnum;
import com.redetex.web.model.exception.CustomException;
import com.redetex.web.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/buscar")
    public ResponseEntity<List<ClienteDTO>> buscarTodosClientes() {
        return ResponseEntity.ok(clienteService.listarTodosClientes());
    }

    @GetMapping(value = "/buscar/{idCliente}")
    public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(clienteService.detalharCliente(idCliente));
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<ClienteDTO> salvarCliente(@RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(clienteService.salvarCliente(cliente));
    }

    @GetMapping(value = "/cancelar/{idCliente}")
    public ResponseEntity<ClienteDTO> cancelarCliente(@PathVariable Long idCliente) throws CustomException {
        return ResponseEntity.ok(clienteService.cancelarCliente(idCliente));
    }

    @GetMapping(value = "/ativar/{idCliente}")
    public ResponseEntity<ClienteDTO> ativarCliente(@PathVariable Long idCliente) throws CustomException {
        return ResponseEntity.ok(clienteService.ativarCliente(idCliente));
    }

    @PostMapping(value = "/consultar")
    public ResponseEntity<List<Cliente>> consultarCliente(
            @RequestParam(required = false) Long idCliente,
            @RequestParam(required = false) String nomeCliente,
            @RequestParam(required = false) String telefoneCliente) throws CustomException {

        Cliente cliente =
                Cliente.builder()
                        .idCliente(idCliente)
                        .nomeCliente(nomeCliente)
                        .telefoneCliente(telefoneCliente)
                        .build();

        return ResponseEntity.ok(clienteService.consultarClientes(cliente));
    }
}
