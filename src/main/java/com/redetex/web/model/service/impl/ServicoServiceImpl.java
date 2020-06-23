package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Servico;
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
    public List<Servico> listarTodosServicos() {

        // Buscar

        // Retornar
        return servicoRepository.findAll();
    }

    @Override
    public Servico listarServico(Long idServico) {

        // Buscar

        // Retornar
        return servicoRepository.findByIdServico(idServico);
    }

    @Override
    public void salvarServico(Servico servico) {

    }

    @Override
    public void concluirServico(Long idServico) {

    }

    @Override
    public void cancelarServico(Long idServico) {

        // Buscar

        // Verificar situacao

        // Setar situacao

        // Salvar

    }
}
