package com.redetex.web.model.service.impl;

import static com.redetex.web.model.exception.DefaultException.*;
import com.redetex.web.model.entidade.Servico;
import com.redetex.web.model.entidade.dto.ServicoDTO;
import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.exception.CustomException;
import com.redetex.web.model.repository.ServicoRepository;
import com.redetex.web.model.service.ServicoService;
import com.redetex.web.model.utilities.RedetexValidacoes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired private ServicoRepository servicoRepository;
    @Autowired private ModelMapper modelMapper;

    @Override
    public List<ServicoDTO> listarTodosServicos() {

        List<ServicoDTO> listaTodosServicosDTO = new ArrayList<>();
        List<Servico> listaTodosServicos = servicoRepository.findAll();

        listaTodosServicos.forEach(servico ->
            listaTodosServicosDTO.add(
                ServicoDTO
                    .builder()
                    .idServico(servico.getIdServico())
                    .situacaoServico(servico.getSituacaoServico())
                    .orcamentoServico(servico.getOrcamentoServico())
                    .dataInstalacaoServico(servico.getDataInstalacaoServico())
                    .observacaoServico(servico.getObservacaoServico())
                    .build()
            )
        );

        return listaTodosServicosDTO;
    }

    @Override
    public ServicoDTO listarServico(Integer idServico) {

        Optional<Servico> servico = servicoRepository.findById(idServico);

        return !servico.isPresent()
                ? ServicoDTO.builder().build()
                : modelMapper.map(servico.get(), ServicoDTO.class);
    }

    @Override
    public ServicoDTO salvarServico(ServicoDTO servicoDTO) throws CustomException {

        Optional<Servico> servico = servicoRepository.findById(servicoDTO.getIdServico().intValue());

        ifTrueThrowException(!servico.isPresent(), RedetexValidacoes.ERRO_SERVICO_NAO_EXISTE);

        Servico servicoAlterado = servico.get();
        servicoAlterado.setObservacaoServico(servicoDTO.getObservacaoServico());
        servicoAlterado.setDataInstalacaoServico(servicoDTO.getDataInstalacaoServico());
        servicoAlterado.setOrcamentoServico(servicoDTO.getOrcamentoServico());
        servicoAlterado.setSituacaoServico(servicoDTO.getSituacaoServico());
        servicoRepository.save(servicoAlterado);

        return modelMapper.map(servicoAlterado, ServicoDTO.class);
    }

    @Override
    public ServicoDTO concluirServico(Integer idServico) throws CustomException {

        Optional<Servico> servico = servicoRepository.findById(idServico);

        ifTrueThrowException(!servico.isPresent(), RedetexValidacoes.ERRO_SERVICO_NAO_EXISTE);

        Servico servicoConcluido = servico.get();

        ifTrueThrowException(servicoConcluido.getSituacaoServico().equals(SituacaoEnum.CANCELADO)
                || servicoConcluido.getSituacaoServico().equals(SituacaoEnum.CONCLUIDO),
                RedetexValidacoes.ERRO_SITUACAO_INVALIDA);

        servicoConcluido.setSituacaoServico(SituacaoEnum.CONCLUIDO);
        servicoRepository.save(servicoConcluido);
        return modelMapper.map(servicoConcluido, ServicoDTO.class);
    }

    @Override
    public ServicoDTO cancelarServico(Integer idServico) throws CustomException {

        Optional<Servico> servico = servicoRepository.findById(idServico);

        ifTrueThrowException(!servico.isPresent(), RedetexValidacoes.ERRO_SERVICO_NAO_EXISTE);

        Servico servicoCancelado = servico.get();

        ifTrueThrowException(servicoCancelado.getSituacaoServico().equals(SituacaoEnum.CANCELADO)
                || servicoCancelado.getSituacaoServico().equals(SituacaoEnum.CONCLUIDO),
                RedetexValidacoes.ERRO_SITUACAO_INVALIDA);

        servicoCancelado.setSituacaoServico(SituacaoEnum.CANCELADO);
        servicoRepository.save(servicoCancelado);
        return modelMapper.map(servicoCancelado, ServicoDTO.class);
    }
}
