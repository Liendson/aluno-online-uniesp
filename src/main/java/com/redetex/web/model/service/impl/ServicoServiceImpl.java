package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Servico;
import com.redetex.web.model.entidade.dto.ServicoDTO;
import com.redetex.web.model.repository.ServicoRepository;
import com.redetex.web.model.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public List<ServicoDTO> listarTodosServicos() {

        // Adicionar filtros

        return servicoRepository.findAll();
    }

    @Override
    public ServicoDTO listarServico(Long idServico) {

        return servicoRepository.findByIdServico(idServico);
    }

    @Override
    public ServicoDTO salvarServico(ServicoDTO servico) {

        return servicoRepository.salvar(servico);

    }

    @Override
    public ServicoDTO concluirServico(Long idServico) {

        ServicoDTO servicoConcluido = listarServico(idServico);

        return servicoRepository.concluir(servicoConcluido);
    }

    @Override
    public ServicoDTO cancelarServico(Long idServico) {

        ServicoDTO servicoCancelado = listarServico(idServico);

        return servicoRepository.cancelar(servicoCancelado);
        // Verificar situacao

    }
}
