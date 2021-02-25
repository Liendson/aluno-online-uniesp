package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    @Query(value = "SELECT * FROM TB_SERVICOS WHERE SITSERVICO IN (1);", nativeQuery = true)
    List<Servico> findAllServicosAtivos();

}
