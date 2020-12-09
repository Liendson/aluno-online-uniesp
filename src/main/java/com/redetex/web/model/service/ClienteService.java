package com.redetex.web.model.service;

import com.redetex.web.model.entidade.dto.ClienteDTO;
import com.redetex.web.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    List<ClienteDTO> listarTodosClientes();
    List<ClienteDTO> consultarClientes(ClienteDTO clienteDTO) throws CustomException;

    ClienteDTO detalharCliente(Integer idCliente);
    ClienteDTO salvarCliente(ClienteDTO cliente);
    ClienteDTO cancelarCliente(Integer idCliente) throws CustomException;
    ClienteDTO ativarCliente(Integer idCliente) throws CustomException;

}
