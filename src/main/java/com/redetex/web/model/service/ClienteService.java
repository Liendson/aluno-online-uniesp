package com.redetex.web.model.service;

import com.redetex.web.model.entidade.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listarTodosClientes();

    Cliente listarCliente(Long idCliente);

    void salvarCliente(Cliente cliente);

    void cancelarCliente(Long idCliente);
}
