package com.redetex.web.model.service;

import com.redetex.web.model.entidade.dto.ClienteDTO;
import com.redetex.web.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    List<ClienteDTO> listarTodosClientes();

    ClienteDTO listarCliente(Integer idCliente);

    ClienteDTO cancelarCliente(Integer idCliente) throws CustomException;

    ClienteDTO salvarCliente(ClienteDTO cliente);

    ClienteDTO ativarCliente(Integer idCliente) throws CustomException;

}
