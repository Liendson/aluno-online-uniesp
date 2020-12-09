package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.Endereco;
import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.entidade.dto.OrcamentoDTO;
import com.redetex.web.model.enums.SituacaoClienteEnum;
import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.exception.CustomException;
import com.redetex.web.model.repository.ClienteRepository;
import com.redetex.web.model.repository.EnderecoRepository;
import com.redetex.web.model.repository.OrcamentoRepository;
import com.redetex.web.model.service.OrcamentoService;
import com.redetex.web.model.utilities.RedetexValidacoes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.redetex.web.model.exception.DefaultException.ifTrueThrowException;

@Service
public class OrcamentoServiceImpl implements OrcamentoService {

    @Autowired private OrcamentoRepository orcamentoRepository;
    @Autowired private EnderecoRepository enderecoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private ModelMapper modelMapper;

    /**
     * Lista todos os Orcamentos ativos.
     *
     * @return uma lista contendo todos os orcamentos
     * @author Liendson Douglas
     */
    @Override
    public List<OrcamentoDTO> listarTodosOrcamentos() {

        List<OrcamentoDTO> listaTodosOrcamentosDTO = new ArrayList<>();
        List<Orcamento> listaTodosOrcamentos =
                orcamentoRepository.findAllOrcamentosAtivos();

        listaTodosOrcamentos.forEach(orcamento ->
            listaTodosOrcamentosDTO.add(
                OrcamentoDTO
                    .builder()
                    .idOrcamento(orcamento.getIdOrcamento())
                    .clienteOrcamento(orcamento.getClienteOrcamento())
                    .enderecoOrcamento(orcamento.getEnderecoOrcamento())
                    .medidasOrcamento(orcamento.getMedidasOrcamento())
                    .situacaoOrcamento(orcamento.getSituacaoOrcamento())
                    .tipoOrcamento(orcamento.getTipoOrcamento())
                    .observacaoOrcamento(orcamento.getObservacaoOrcamento())
                    .valorOrcamento(orcamento.getValorOrcamento())
                    .build()
            )
        );

        return listaTodosOrcamentosDTO;

    }

    /**
     * Detalha os dados de um orcamento.
     *
     * @return os dados do orçamento ou um orçamento vazio
     * @author Liendson Douglas
     */
    @Override
    public OrcamentoDTO detalharOrcamento(Long id) throws CustomException {

        ifTrueThrowException(Objects.isNull(id),
                RedetexValidacoes.ERRO_ORCAMENTO_NAO_EXISTE);

        Optional<Orcamento> orcamento =
                orcamentoRepository.findById(id);

        return !orcamento.isPresent()
                ? OrcamentoDTO.builder().build()
                : modelMapper.map(orcamento.get(), OrcamentoDTO.class);

    }

    /**
     * Altera ou insere um Orcamento.
     *
     * @return o orçamento incluído ou alterado
     * @author Liendson Douglas
     * @see #incluirOrcamento(OrcamentoDTO)
     * @see #alterarOrcamento(Orcamento, OrcamentoDTO)
     */
    @Override
    public OrcamentoDTO salvarOrcamento(OrcamentoDTO orcamentoDTO) throws CustomException {

        if (Objects.nonNull(orcamentoDTO.getIdOrcamento())) {
            Optional<Orcamento> orcamento =
                    orcamentoRepository.findById(orcamentoDTO.getIdOrcamento());

            return alterarOrcamento(orcamento.get(), orcamentoDTO);

        }

        return incluirOrcamento(orcamentoDTO);

    }

    /**
     * Inclui um Orcamento.
     *
     * @return o orçamento incluído
     * @author Liendson Douglas
     * @see #salvarOrcamento(OrcamentoDTO)
     */
    private OrcamentoDTO incluirOrcamento(OrcamentoDTO orcamentoDTO) {

        Orcamento orcamentoIncluido = new Orcamento();

        if (Objects.nonNull(orcamentoDTO.getClienteOrcamento().getIdCliente())) {
            Optional<Cliente> cliente =
                    clienteRepository.findById(orcamentoDTO.getClienteOrcamento().getIdCliente().intValue());
            orcamentoIncluido.setClienteOrcamento(cliente.get());
        } else {
            orcamentoDTO.getClienteOrcamento().setSituacao(SituacaoClienteEnum.ATIVO);
            orcamentoIncluido.setClienteOrcamento(orcamentoDTO.getClienteOrcamento());
        }

        orcamentoIncluido.setEnderecoOrcamento(orcamentoDTO.getEnderecoOrcamento());
        orcamentoIncluido.setObservacaoOrcamento(orcamentoDTO.getObservacaoOrcamento());
        orcamentoIncluido.setSituacaoOrcamento(SituacaoEnum.NOVO);
        orcamentoIncluido.setTipoOrcamento(orcamentoDTO.getTipoOrcamento());
        orcamentoIncluido.setValorOrcamento(orcamentoDTO.getValorOrcamento());

        Cliente clienteIncluido = clienteRepository.save(orcamentoDTO.getClienteOrcamento());
        Endereco enderecoIncluido = enderecoRepository.save(orcamentoDTO.getEnderecoOrcamento());

        orcamentoIncluido.setClienteOrcamento(clienteIncluido);
        orcamentoIncluido.setEnderecoOrcamento(enderecoIncluido);

        orcamentoRepository.save(orcamentoIncluido);

        return modelMapper.map(orcamentoIncluido, OrcamentoDTO.class);

    }

    /**
     * Altera um Orcamento.
     *
     * @return o orçamento alterado
     * @author Liendson Douglas
     * @see #salvarOrcamento(OrcamentoDTO)
     */
    private OrcamentoDTO alterarOrcamento(Orcamento orcamento, OrcamentoDTO orcamentoDTO) {

        orcamento.setClienteOrcamento(orcamentoDTO.getClienteOrcamento());
        orcamento.setEnderecoOrcamento(orcamentoDTO.getEnderecoOrcamento());
        orcamento.setObservacaoOrcamento(orcamentoDTO.getObservacaoOrcamento());
        orcamento.setSituacaoOrcamento(orcamentoDTO.getSituacaoOrcamento());
        orcamento.setTipoOrcamento(orcamentoDTO.getTipoOrcamento());
        orcamento.setValorOrcamento(orcamentoDTO.getValorOrcamento());
        orcamento.setMedidasOrcamento(orcamentoDTO.getMedidasOrcamento());

        orcamentoRepository.save(orcamento);

        return modelMapper.map(orcamento, OrcamentoDTO.class);

    }

    /**
     * Altera a situacao de um Orcamento para concluido.
     *
     * @return o orçamento alterado
     * @author Liendson Douglas
     */
    @Override
    public OrcamentoDTO concluirOrcamento(Long idOrcamento) throws CustomException {

        ifTrueThrowException(Objects.isNull(idOrcamento),
                RedetexValidacoes.ERRO_ORCAMENTO_NAO_EXISTE);

        Optional<Orcamento> orcamento = orcamentoRepository.findById(idOrcamento);

        ifTrueThrowException(!orcamento.isPresent(),
                RedetexValidacoes.ERRO_ORCAMENTO_NAO_EXISTE);

        Orcamento orcamentoConcluido = orcamento.get();

        ifTrueThrowException(orcamentoConcluido.getSituacaoOrcamento().equals(SituacaoEnum.CANCELADO)
                || orcamentoConcluido.getSituacaoOrcamento().equals(SituacaoEnum.CONCLUIDO),
                RedetexValidacoes.ERRO_SITUACAO_INVALIDA);

        orcamentoConcluido.setSituacaoOrcamento(SituacaoEnum.CONCLUIDO);
        orcamentoRepository.save(orcamentoConcluido);
        return modelMapper.map(orcamentoConcluido, OrcamentoDTO.class);

    }

    /**
     * Altera a situacao de um Orcamento para cancelado.
     *
     * @return o orçamento alterado
     * @author Liendson Douglas
     */
    @Override
    public OrcamentoDTO cancelarOrcamento(Long idOrcamento) throws CustomException {

        ifTrueThrowException(Objects.isNull(idOrcamento),
                RedetexValidacoes.ERRO_ORCAMENTO_NAO_EXISTE);

        Optional<Orcamento> orcamento = orcamentoRepository.findById(idOrcamento);

        ifTrueThrowException(!orcamento.isPresent(),
                RedetexValidacoes.ERRO_ORCAMENTO_NAO_EXISTE);

        Orcamento servicoCancelado = orcamento.get();

        ifTrueThrowException(servicoCancelado.getSituacaoOrcamento().equals(SituacaoEnum.CANCELADO)
                || servicoCancelado.getSituacaoOrcamento().equals(SituacaoEnum.CONCLUIDO),
                RedetexValidacoes.ERRO_SITUACAO_INVALIDA);

        servicoCancelado.setSituacaoOrcamento(SituacaoEnum.CANCELADO);
        orcamentoRepository.save(servicoCancelado);
        return modelMapper.map(servicoCancelado, OrcamentoDTO.class);

    }

    /**
     * Consulta um ou mais orçamentos de acordo com os filtos passados.
     *
     * @return a lista de orcamentos encontrados
     * @author Liendson Douglas
     */
    @Override
    public List<OrcamentoDTO> consultarOrcamentos(OrcamentoDTO orcamentoDTO) throws CustomException {

        List<OrcamentoDTO> listaTodosOrcamentosDTO = new ArrayList<>();

        // TODO: filtrar e realizar consulta

        return listaTodosOrcamentosDTO;
    }
}
