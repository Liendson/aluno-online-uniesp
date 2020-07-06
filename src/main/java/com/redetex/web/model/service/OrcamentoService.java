package com.redetex.web.model.service;

import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.entidade.dto.OrcamentoDTO;

import java.util.List;

public interface OrcamentoService {

    List<Orcamento> listarTodosOrcamentos();

    OrcamentoDTO listarOrcamento(Long idOrcamento);

    OrcamentoDTO salvarOrcamento(OrcamentoDTO orcamento);

    OrcamentoDTO concluirOrcamento(Long idOrcamento);

    OrcamentoDTO cancelarOrcamento(Long idOrcamento);
}
