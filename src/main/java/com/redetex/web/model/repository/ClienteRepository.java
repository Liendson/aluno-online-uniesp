package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findAll();

    @Query(value = "SELECT * FROM TB_CLIENTES WHERE SITCLIENTE IN (0);", nativeQuery = true)
    List<Cliente> findAllClientesAtivos();

}
