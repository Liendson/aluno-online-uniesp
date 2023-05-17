package com.alunoonline.api.model.service;

import com.alunoonline.api.model.entidade.dto.ProfessorDTO;
import com.alunoonline.api.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {

    List<ProfessorDTO> listarTodos();

    ProfessorDTO buscarPorId(Long id) throws CustomException;

    ProfessorDTO salvar(ProfessorDTO professorDTO) throws CustomException;

    ProfessorDTO deletar(Long id) throws CustomException;
}
