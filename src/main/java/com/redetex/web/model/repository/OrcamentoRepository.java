package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {

    List<Orcamento> findAll();

    @Query(value = "SELECT * FROM TB_ORCAMENTOS WHERE STORCAMENTO IN (0,1);", nativeQuery = true)
    List<Orcamento> findAllOrcamentosAtivos();
}
