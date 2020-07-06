package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.dto.ClienteDTO;
import com.redetex.web.model.enums.SituacaoClienteEnum;
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
    public List<ClienteDTO> listarTodosClientes() {

        // Buscar

        // Retornar
        return clienteRepository.findAll();
    }

    @Override
    public ClienteDTO listarCliente(Long idCliente) {

        // Buscar

        // Retornar
        return clienteRepository.findByIdCliente(idCliente);
    }

    @Override
    public ClienteDTO salvarCliente(ClienteDTO cliente) {

        return clienteRepository.salvar(cliente);
    }

    @Override
    public ClienteDTO cancelarCliente(Long idCliente) {

        ClienteDTO clienteCancelar = listarCliente(idCliente);

        return clienteRepository.cancelar(clienteCancelar);

        // Verificar situacao

        // Setar situacao

        // Salvar

    }

}
