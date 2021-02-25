package com.redetex.web.model.service;

import com.redetex.web.model.entidade.Servico;
import com.redetex.web.model.entidade.dto.ServicoDTO;
import com.redetex.web.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicoService {

    List<ServicoDTO> listarTodosServicos();
    List<Servico> consultarServicos(Servico servico) throws CustomException;

    ServicoDTO detalharServico(Long idServico);
    ServicoDTO salvarServico(ServicoDTO servico) throws CustomException;
    ServicoDTO concluirServico(Long idServico) throws CustomException;
    ServicoDTO cancelarServico(Long idServico) throws CustomException;
}
