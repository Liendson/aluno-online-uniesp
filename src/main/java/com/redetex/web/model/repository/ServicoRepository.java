package com.redetex.web.model.repository;

import com.redetex.web.model.entidade.Servico;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository {

    Servico findByIdServico(Long idServico);

    Servico findAll();

}
