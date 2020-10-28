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

//    Cliente findByIdCliente(Long idCliente);

//    Cliente salvar(Cliente cliente);

//    Cliente cancelar(Cliente cliente);

    @Query(value = "SELECT * FROM TB_CLIENTES;", nativeQuery = true)
    List<Cliente> findAll();

}
