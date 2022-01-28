package com.redetex.web.model.service;

import com.redetex.web.model.entidade.dto.ProcedimentoDTO;
import com.redetex.web.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProcedimentoService {

    List<ProcedimentoDTO> listarProcedimentosParaHoje() throws CustomException;

    List<ProcedimentoDTO> listarProcedimentosParaSemana() throws CustomException;

}
