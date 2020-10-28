package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.entidade.dto.OrcamentoDTO;
import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.exception.CustomException;
import com.redetex.web.model.repository.OrcamentoRepository;
import com.redetex.web.model.service.OrcamentoService;
import com.redetex.web.model.utilities.RedetexValidacoes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoServiceImpl implements OrcamentoService {

    @Autowired private OrcamentoRepository orcamentoRepository;
    @Autowired private ModelMapper modelMapper;

    @Override
    public List<OrcamentoDTO> listarTodosOrcamentos() {

        List<OrcamentoDTO> listaTodosOrcamentosDTO = new ArrayList<>();
        List<Orcamento> listaTodosOrcamentos = orcamentoRepository.findAll();

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

    @Override
    public OrcamentoDTO listarOrcamento(Integer idOrcamento) {

        Optional<Orcamento> orcamento = orcamentoRepository.findById(idOrcamento);

        if (!orcamento.isPresent()) {
            return OrcamentoDTO.builder().build();
        }

        return modelMapper.map(orcamento.get(), OrcamentoDTO.class);

    }

    @Override
    public OrcamentoDTO salvarOrcamento(OrcamentoDTO orcamentoDTO) throws CustomException {

        Optional<Orcamento> orcamento = orcamentoRepository.findById(orcamentoDTO.getIdOrcamento());

        if (!orcamento.isPresent()) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }

        Orcamento orcamentoAlterado = orcamento.get();
        orcamentoAlterado.setClienteOrcamento(orcamentoAlterado.getClienteOrcamento());
        orcamentoAlterado.setEnderecoOrcamento(orcamentoAlterado.getEnderecoOrcamento());
        orcamentoAlterado.setObservacaoOrcamento(orcamentoAlterado.getObservacaoOrcamento());
        orcamentoAlterado.setSituacaoOrcamento(orcamentoAlterado.getSituacaoOrcamento());
        orcamentoAlterado.setTipoOrcamento(orcamentoAlterado.getTipoOrcamento());
        orcamentoAlterado.setValorOrcamento(orcamentoAlterado.getValorOrcamento());
        orcamentoAlterado.setMedidasOrcamento(orcamentoAlterado.getMedidasOrcamento());
        orcamentoRepository.save(orcamentoAlterado);

        return modelMapper.map(orcamentoAlterado, OrcamentoDTO.class);

    }

    @Override
    public OrcamentoDTO concluirOrcamento(Integer idOrcamento) throws CustomException {

        Optional<Orcamento> orcamento = orcamentoRepository.findById(idOrcamento);

        if (!orcamento.isPresent()) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }

        Orcamento orcamentoConcluido = orcamento.get();
        if (orcamentoConcluido.getSituacaoOrcamento().equals(SituacaoEnum.CANCELADO)
                || orcamentoConcluido.getSituacaoOrcamento().equals(SituacaoEnum.CONCLUIDO)) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }
        orcamentoConcluido.setSituacaoOrcamento(SituacaoEnum.CONCLUIDO);
        orcamentoRepository.save(orcamentoConcluido);
        return modelMapper.map(orcamentoConcluido, OrcamentoDTO.class);

    }

    @Override
    public OrcamentoDTO cancelarOrcamento(Integer idOrcamento) throws CustomException {

        Optional<Orcamento> orcamento = orcamentoRepository.findById(idOrcamento);

        if (!orcamento.isPresent()) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }

        Orcamento servicoCancelado = orcamento.get();
        if (servicoCancelado.getSituacaoOrcamento().equals(SituacaoEnum.CANCELADO)
                || servicoCancelado.getSituacaoOrcamento().equals(SituacaoEnum.CONCLUIDO)) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }
        servicoCancelado.setSituacaoOrcamento(SituacaoEnum.CANCELADO);
        orcamentoRepository.save(servicoCancelado);
        return modelMapper.map(servicoCancelado, OrcamentoDTO.class);

    }
}
