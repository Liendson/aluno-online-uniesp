package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Orcamento;
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
    public List<Orcamento> listarTodosOrcamentos() {

        // Buscar

        // Retornar
        return orcamentoRepository.findAll();
    }

    @Override
    public Orcamento listarOrcamento(Long idOrcamento) {

        // Buscar

        // Retornar
        return orcamentoRepository.findByIdOrcamento(idOrcamento);
    }

    @Override
    public void salvarOrcamento(Orcamento orcamento) {

    }

    @Override
    public void concluirOrcamento(Long idOrcamento) {

    }

    @Override
    public void cancelarOrcamento(Long idOrcamento) {

        // Buscar

        // Verificar situacao

        // Setar situacao

        // Salvar

    }
}
