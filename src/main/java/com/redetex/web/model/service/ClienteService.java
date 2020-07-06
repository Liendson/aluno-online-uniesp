package com.redetex.web.model.service;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> listarTodosClientes();

    ClienteDTO listarCliente(Long idCliente);

    ClienteDTO salvarCliente(ClienteDTO cliente);

    ClienteDTO cancelarCliente(Long idCliente);
}
