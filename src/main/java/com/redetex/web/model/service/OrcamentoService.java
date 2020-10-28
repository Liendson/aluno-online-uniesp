package com.redetex.web.model.service;

import com.redetex.web.model.entidade.dto.OrcamentoDTO;
import com.redetex.web.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrcamentoService {

    List<OrcamentoDTO> listarTodosOrcamentos();

    OrcamentoDTO listarOrcamento(Integer idOrcamento);

    OrcamentoDTO salvarOrcamento(OrcamentoDTO orcamento) throws CustomException;

    OrcamentoDTO concluirOrcamento(Integer idOrcamento) throws CustomException;

    OrcamentoDTO cancelarOrcamento(Integer idOrcamento) throws CustomException;
}
