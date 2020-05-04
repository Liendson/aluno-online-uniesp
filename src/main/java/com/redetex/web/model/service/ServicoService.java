package com.redetex.web.model.service;

import com.redetex.web.model.entidade.Servico;
import java.util.List;

public interface ServicoService {

    List<Servico> listarTodosServicos();

    Servico listarServico(Long idServico);

    void salvarServico(Servico servico);

    void concluirServico(Long idServico);

    void cancelarServico(Long idServico);
}
