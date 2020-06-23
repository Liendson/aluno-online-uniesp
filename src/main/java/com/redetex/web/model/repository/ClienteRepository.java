package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository {

    Cliente findByIdCliente(Long idCliente);

    @Query(value = "SELECT * FROM TB_CLIENTES")
    Cliente findAll();

}
