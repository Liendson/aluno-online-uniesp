package com.redetex.web.model.service;

import com.redetex.web.model.entidade.Servico;
import com.redetex.web.model.entidade.dto.ServicoDTO;

import java.util.List;

public interface ServicoService {

    List<ServicoDTO> listarTodosServicos();

    ServicoDTO listarServico(Long idServico);

    ServicoDTO salvarServico(ServicoDTO servico);

    ServicoDTO concluirServico(Long idServico);

    ServicoDTO cancelarServico(Long idServico);
}
