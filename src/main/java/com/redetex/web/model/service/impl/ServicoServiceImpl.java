package com.redetex.web.model.service.impl;

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

        if (!servico.isPresent()) {
            return ServicoDTO.builder().build();
        }

        return modelMapper.map(servico.get(), ServicoDTO.class);
    }

    @Override
    public ServicoDTO salvarServico(ServicoDTO servicoDTO) throws CustomException {

        Optional<Servico> servico = servicoRepository.findById(servicoDTO.getIdServico());

        if (!servico.isPresent()) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }

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

        if (!servico.isPresent()) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }

        Servico servicoConcluido = servico.get();
        if (servicoConcluido.getSituacaoServico().equals(SituacaoEnum.CANCELADO)
                || servicoConcluido.getSituacaoServico().equals(SituacaoEnum.CONCLUIDO)) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }
        servicoConcluido.setSituacaoServico(SituacaoEnum.CONCLUIDO);
        servicoRepository.save(servicoConcluido);
        return modelMapper.map(servicoConcluido, ServicoDTO.class);
    }

    @Override
    public ServicoDTO cancelarServico(Integer idServico) throws CustomException {

        Optional<Servico> servico = servicoRepository.findById(idServico);

        if (!servico.isPresent()) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }

        Servico servicoCancelado = servico.get();
        if (servicoCancelado.getSituacaoServico().equals(SituacaoEnum.CANCELADO)
                || servicoCancelado.getSituacaoServico().equals(SituacaoEnum.CONCLUIDO)) {
            throw new CustomException(RedetexValidacoes.ERRO_001);
        }
        servicoCancelado.setSituacaoServico(SituacaoEnum.CANCELADO);
        servicoRepository.save(servicoCancelado);
        return modelMapper.map(servicoCancelado, ServicoDTO.class);

    }
}
