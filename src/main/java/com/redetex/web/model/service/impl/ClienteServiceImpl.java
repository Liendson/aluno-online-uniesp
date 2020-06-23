package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.repository.ClienteRepository;
import com.redetex.web.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodosClientes() {

        // Buscar

        // Retornar
        return clienteRepository.findAll();
    }

    @Override
    public Cliente listarCliente(Long idCliente) {

        // Buscar

        // Retornar
        return clienteRepository.findByIdCliente(idCliente);
    }

    @Override
    public void salvarCliente(Cliente cliente) {

    }

    @Override
    public void cancelarCliente(Long idCliente) {

        // Buscar

        // Verificar situacao

        // Setar situacao

        // Salvar

    }

}
