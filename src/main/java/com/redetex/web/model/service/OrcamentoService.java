package com.redetex.web.model.service;

import com.redetex.web.model.entidade.Orcamento;
import java.util.List;

public interface OrcamentoService {

    List<Orcamento> listarTodosOrcamentos();

    Orcamento listarOrcamento(Long idOrcamento);

    void salvarOrcamento(Orcamento orcamento);

    void concluirOrcamento(Long idOrcamento);

    void cancelarOrcamento(Long idOrcamento);
}
