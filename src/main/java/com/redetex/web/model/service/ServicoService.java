package com.redetex.web.model.service;

import com.redetex.web.model.entidade.dto.ServicoDTO;
import com.redetex.web.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicoService {

    List<ServicoDTO> listarTodosServicos();
    List<ServicoDTO> consultarServicos(ServicoDTO servicoDTO) throws CustomException;

    ServicoDTO detalharServico(Integer idServico);
    ServicoDTO salvarServico(ServicoDTO servico) throws CustomException;
    ServicoDTO concluirServico(Integer idServico) throws CustomException;
    ServicoDTO cancelarServico(Integer idServico) throws CustomException;
}
