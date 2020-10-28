package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.dto.ClienteDTO;
import com.redetex.web.model.enums.SituacaoClienteEnum;
import com.redetex.web.model.exception.CustomException;
import com.redetex.web.model.repository.ClienteRepository;
import com.redetex.web.model.service.ClienteService;
import com.redetex.web.model.utilities.RedetexValidacoes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired private ClienteRepository clienteRepository;
    @Autowired private ModelMapper modelMapper;

    @Override
    public List<ClienteDTO> listarTodosClientes() {

        List<ClienteDTO> listaTodosClientesDTO = new ArrayList<>();
        List<Cliente> listaTodosClientes = clienteRepository.findAll();

        listaTodosClientes.forEach(cliente ->
            listaTodosClientesDTO.add(
                ClienteDTO
                    .builder()
                    .idCliente(cliente.getIdCliente())
                    .nomeCliente(cliente.getNomeCliente())
                    .telefoneCliente(cliente.getTelefoneCliente())
                    .situacao(cliente.getSituacao())
                    .build()
            )
        );

        return listaTodosClientesDTO;

    }

    @Override
    public ClienteDTO listarCliente(Integer idCliente) {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        if (!cliente.isPresent()) {
            return ClienteDTO.builder().build();
        }

        return modelMapper.map(cliente.get(), ClienteDTO.class);
    }

    @Override
    public ClienteDTO salvarCliente(ClienteDTO clienteDTO) {

        Optional<Cliente> cliente = clienteRepository.findById(clienteDTO.getIdCliente());

        Cliente clienteAlterado = cliente.orElseGet(Cliente::new);
        clienteAlterado.setNomeCliente(clienteDTO.getNomeCliente());
        clienteAlterado.setSituacao(clienteDTO.getSituacao());
        clienteAlterado.setTelefoneCliente(clienteDTO.getTelefoneCliente());
        clienteRepository.save(clienteAlterado);
        return modelMapper.map(clienteAlterado, ClienteDTO.class);

    }

    @Override
    public ClienteDTO cancelarCliente(Integer idCliente) throws CustomException {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        if (!cliente.isPresent()) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }

        Cliente clienteCancelado = cliente.get();

        if (clienteCancelado.getSituacao().equals(SituacaoClienteEnum.CANCELADO)) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }
        clienteCancelado.setSituacao(SituacaoClienteEnum.CANCELADO);
        clienteRepository.save(clienteCancelado);
        return modelMapper.map(clienteCancelado, ClienteDTO.class);

    }

}
