package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Servico;
import com.redetex.web.model.entidade.dto.ServicoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository {

    ServicoDTO findByIdServico(Long idServico);

    ServicoDTO cancelar(ServicoDTO servico);

    ServicoDTO salvar(ServicoDTO servico);

    ServicoDTO concluir(ServicoDTO servico);

    @Query(value = "SELECT * FROM TB_SERVICOS")
    List<ServicoDTO> findAll();

}
