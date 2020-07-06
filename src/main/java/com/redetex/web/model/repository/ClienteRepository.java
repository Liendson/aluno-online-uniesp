package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.dto.ClienteDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository {

    ClienteDTO findByIdCliente(Long idCliente);

    ClienteDTO salvar(ClienteDTO cliente);

    ClienteDTO cancelar(ClienteDTO cliente);

    @Query(value = "SELECT * FROM TB_CLIENTES")
    List<ClienteDTO> findAll();

}
