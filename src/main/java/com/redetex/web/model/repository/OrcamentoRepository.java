package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Orcamento;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository {

    Orcamento findByIdOrcamento(Long idOcamento);

    Orcamento findAll();
}
