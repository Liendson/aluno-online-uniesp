package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {

//    OrcamentoDTO findByIdOrcamento(Long idOrcamento);
//
//    OrcamentoDTO salvar(OrcamentoDTO orcamento);
//
//    OrcamentoDTO cancelar(OrcamentoDTO orcamento);
//
//    OrcamentoDTO concluir(OrcamentoDTO orcamento);

    @Query(value = "SELECT * FROM TB_ORCAMENTOS;", nativeQuery = true)
    List<Orcamento> findAll();
}
