package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    @Query(value = "SELECT * FROM TB_ORCAMENTOS WHERE STORCAMENTO IN (0,1);", nativeQuery = true)
    List<Orcamento> findAllOrcamentosAtivos();

    @Query(value = "select * from TB_ORCAMENTOS where DATE(DTORCAMENTO) = CURDATE();", nativeQuery = true)
    List<Orcamento> findAllOrcamentosParaHoje();

    @Query(value = "SELECT * FROM TB_ORCAMENTOS WHERE DTORCAMENTO IN (0,1);", nativeQuery = true)
    List<Orcamento> findAllOrcamentosParaSemana();
}
