package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.entidade.dto.OrcamentoDTO;
import com.redetex.web.model.repository.OrcamentoRepository;
import com.redetex.web.model.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrcamentoServiceImpl implements OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Override
    public List<OrcamentoDTO> listarTodosOrcamentos() {

        // Buscar

        // Retornar
        return orcamentoRepository.findAll();
    }

    @Override
    public OrcamentoDTO listarOrcamento(Long idOrcamento) {

        // Buscar

        // Retornar
        return orcamentoRepository.findByIdOrcamento(idOrcamento);
    }

    @Override
    public OrcamentoDTO salvarOrcamento(OrcamentoDTO orcamento) {

        return orcamentoRepository.salvar(orcamento);

    }

    @Override
    public OrcamentoDTO concluirOrcamento(Long idOrcamento) {

        OrcamentoDTO orcamentoConcluido = listarOrcamento(idOrcamento);

        return orcamentoRepository.concluir(orcamentoConcluido);

    }

    @Override
    public OrcamentoDTO cancelarOrcamento(Long idOrcamento) {

        OrcamentoDTO orcamentoCancelado = listarOrcamento(idOrcamento);

        return orcamentoRepository.cancelar(orcamentoCancelado);

    }
}
