package com.redetex.web.model.service;

import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.entidade.dto.ConsultarOrcamentoDTO;
import com.redetex.web.model.entidade.dto.OrcamentoDTO;
import com.redetex.web.model.exception.CustomException;
import com.redetex.web.model.repository.OrcamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrcamentoService {

    List<OrcamentoDTO> listarTodosOrcamentos();

    List<Orcamento> consultarOrcamentos(ConsultarOrcamentoDTO orcamento) throws CustomException;

    OrcamentoDTO detalharOrcamento(Long idOrcamento) throws CustomException;

    OrcamentoDTO salvarOrcamento(OrcamentoDTO orcamento) throws CustomException;

    OrcamentoDTO concluirOrcamento(Long idOrcamento) throws CustomException;

    OrcamentoDTO cancelarOrcamento(Long idOrcamento) throws CustomException;

    OrcamentoRepository getRepository();
}
