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
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.redetex.web.model.exception.DefaultException.ifTrueThrowException;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Lista todos os Clientes ativos.
     *
     * @return uma lista contendo todos os clientes
     * @author Liendson Douglas
     */
    @Override
    public List<ClienteDTO> listarTodosClientes() {

        List<ClienteDTO> listaTodosClientesDTO = new ArrayList<>();
        List<Cliente> listaTodosClientes = clienteRepository.findAllClientesAtivos();

        listaTodosClientes.forEach(cliente ->
                listaTodosClientesDTO.add(
                        ClienteDTO
                                .builder()
                                .idCliente(cliente.getIdCliente())
                                .nomeCliente(cliente.getNomeCliente())
                                .telefoneCliente(cliente.getTelefoneCliente())
                                .situacao(cliente.getSituacaoCliente())
                                .build()
                )
        );

        return listaTodosClientesDTO;

    }

    /**
     * Detalha os dados de um Cliente.
     *
     * @return os dados do cliente detalhado
     * @author Liendson Douglas
     */
    @Override
    public ClienteDTO detalharCliente(Long idCliente) {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        return !cliente.isPresent()
                ? ClienteDTO.builder().build()
                : modelMapper.map(cliente.get(), ClienteDTO.class);
    }

    /**
     * Salva o cliente
     *
     * @return o cliente salvo
     * @author Liendson Douglas
     */
    @Override
    public ClienteDTO salvarCliente(ClienteDTO clienteDTO) {

        Optional<Cliente> cliente = clienteRepository.findById(clienteDTO.getIdCliente());

        Cliente clienteAlterado = cliente.orElseGet(Cliente::new);
        clienteAlterado.setNomeCliente(clienteDTO.getNomeCliente());
        clienteAlterado.setSituacaoCliente(clienteDTO.getSituacao());
        clienteAlterado.setTelefoneCliente(clienteDTO.getTelefoneCliente());
        clienteRepository.save(clienteAlterado);
        return modelMapper.map(clienteAlterado, ClienteDTO.class);

    }

    /**
     * Cancela o cliente, mudando a situacao para 'Cancelado'
     *
     * @return o cliente cancelado
     * @author Liendson Douglas
     */
    @Override
    public ClienteDTO cancelarCliente(Long idCliente) throws CustomException {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        ifTrueThrowException(!cliente.isPresent(), RedetexValidacoes.ERRO_CLIENTE_NAO_EXISTE);

        Cliente clienteCancelado = cliente.get();

        ifTrueThrowException(Objects.equals(clienteCancelado.getSituacaoCliente(), SituacaoClienteEnum.CANCELADO),
                RedetexValidacoes.ERRO_SITUACAO_INVALIDA);

        clienteCancelado.setSituacaoCliente(SituacaoClienteEnum.CANCELADO);
        clienteRepository.save(clienteCancelado);
        return modelMapper.map(clienteCancelado, ClienteDTO.class);

    }

    /**
     * Ativa o cliente, mudando a situação para 'Ativo'
     *
     * @return o cliente ativado
     * @author Liendson Douglas
     */
    @Override
    public ClienteDTO ativarCliente(Long idCliente) throws CustomException {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        ifTrueThrowException(!cliente.isPresent(), RedetexValidacoes.ERRO_CLIENTE_NAO_EXISTE);

        Cliente clienteCancelado = cliente.get();

        ifTrueThrowException(Objects.equals(clienteCancelado.getSituacaoCliente(), SituacaoClienteEnum.ATIVO),
                RedetexValidacoes.ERRO_SITUACAO_INVALIDA);

        clienteCancelado.setSituacaoCliente(SituacaoClienteEnum.ATIVO);
        clienteRepository.save(clienteCancelado);
        return modelMapper.map(clienteCancelado, ClienteDTO.class);

    }

    /**
     * Consulta um ou mais clientes de acordo com os filtos passados.
     *
     * @return a lista de clientes encontrados
     * @author Liendson Douglas
     */
    @Override
    public List<Cliente> consultarClientes(Cliente cliente) throws CustomException {

        ifTrueThrowException(Objects.isNull(cliente), RedetexValidacoes.ALERTA_PREENCHA_UM_CAMPO);

        ExampleMatcher customExampleMatcher =
                ExampleMatcher.matching()
                        .withMatcher("situacaoOrcamento",
                                ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        return clienteRepository.findAll(Example.of(cliente, customExampleMatcher));
    }

}
