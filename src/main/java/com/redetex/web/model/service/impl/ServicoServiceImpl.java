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
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.redetex.web.model.exception.DefaultException.ifTrueThrowException;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired private ServicoRepository servicoRepository;
    @Autowired private ModelMapper modelMapper;

    /**
     * Lista todos os Servicos ativos.
     *
     * @return uma lista contendo todos os servicos
     * @author Liendson Douglas
     */
    @Override
    public List<ServicoDTO> listarTodosServicos() {

        List<ServicoDTO> listaTodosServicosDTO = new ArrayList<>();
        List<Servico> listaTodosServicos = servicoRepository.findAllServicosAtivos();

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

    /**
     * Detalha os dados de um Serviço.
     *
     * @return os dados do serviço detalhado ou um serviço vazio
     * @author Liendson Douglas
     */
    @Override
    public ServicoDTO detalharServico(Long idServico) {

        Optional<Servico> servico = servicoRepository.findById(idServico);

        return !servico.isPresent()
                ? ServicoDTO.builder().build()
                : modelMapper.map(servico.get(), ServicoDTO.class);
    }

    /**
     * Altera ou insere um Servico.
     *
     * @return o servico incluído ou alterado
     * @author Liendson Douglas
     */
    @Override
    public ServicoDTO salvarServico(ServicoDTO servicoDTO) throws CustomException {

        Optional<Servico> servico = servicoRepository.findById(servicoDTO.getIdServico());

        ifTrueThrowException(!servico.isPresent(), RedetexValidacoes.ERRO_SERVICO_NAO_EXISTE);

        Servico servicoAlterado = servico.get();
        servicoAlterado.setObservacaoServico(servicoDTO.getObservacaoServico());
        servicoAlterado.setDataInstalacaoServico(servicoDTO.getDataInstalacaoServico());
        servicoAlterado.setOrcamentoServico(servicoDTO.getOrcamentoServico());
        servicoAlterado.setSituacaoServico(servicoDTO.getSituacaoServico());
        servicoRepository.save(servicoAlterado);

        return modelMapper.map(servicoAlterado, ServicoDTO.class);
    }

    /**
     * Altera a situacao de um servico para 'Concluído'.
     *
     * @return o servico concluído
     * @author Liendson Douglas
     */
    @Override
    public ServicoDTO concluirServico(Long idServico) throws CustomException {

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

    /**
     * Altera a situacao de um servico para 'Cancelado'.
     *
     * @return o servico cancelado
     * @author Liendson Douglas
     */
    @Override
    public ServicoDTO cancelarServico(Long idServico) throws CustomException {

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

    /**
     * Consulta um ou mais servicos de acordo com os filtos passados.
     *
     * @return a lista de servicos encontrados
     * @author Liendson Douglas
     */
    @Override
    public List<Servico> consultarServicos(Servico servico) throws CustomException {

        ifTrueThrowException(Objects.isNull(servico), RedetexValidacoes.ALERTA_PREENCHA_UM_CAMPO);

        ExampleMatcher customExampleMatcher =
            ExampleMatcher.matching()
                .withMatcher("situacaoServico",
                    ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        return servicoRepository.findAll(Example.of(servico, customExampleMatcher));

    }
}
