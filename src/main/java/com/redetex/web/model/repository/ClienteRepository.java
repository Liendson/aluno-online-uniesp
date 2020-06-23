package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository {

    Cliente findByIdCliente(Long idCliente);

    @Query(value = "SELECT * FROM TB_CLIENTES")
    List<Cliente> findAll();

}
