package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.entidade.dto.OrcamentoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrcamentoRepository {

    OrcamentoDTO findByIdOrcamento(Long idOrcamento);

    OrcamentoDTO salvar(OrcamentoDTO orcamento);

    OrcamentoDTO cancelar(OrcamentoDTO orcamento);

    OrcamentoDTO concluir(OrcamentoDTO orcamento);

    @Query(value = "SELECT * FROM TB_ORCAMENTOS")
    List<Orcamento> findAll();
}
