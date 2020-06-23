package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Orcamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrcamentoRepository {

    Orcamento findByIdOrcamento(Long idOrcamento);

    @Query(value = "SELECT * FROM TB_ORCAMENTOS")
    List<Orcamento> findAll();
}
