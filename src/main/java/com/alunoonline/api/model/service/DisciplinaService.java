package com.alunoonline.api.model.service;

import com.alunoonline.api.model.entidade.dto.DisciplinaDTO;
import com.alunoonline.api.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DisciplinaService {

    List<DisciplinaDTO> listarTodos();

    DisciplinaDTO buscarPorId(Long id) throws CustomException;

    DisciplinaDTO salvar(DisciplinaDTO disciplinaDTO) throws CustomException;

    DisciplinaDTO deletar(Long id) throws CustomException;

}
