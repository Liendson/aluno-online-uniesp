package com.alunoonline.api.model.service;

import com.alunoonline.api.model.entidade.dto.AlunoDTO;
import com.alunoonline.api.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlunoService {

    List<AlunoDTO> listarTodos();

    AlunoDTO buscarPorId(Long id) throws CustomException;

    AlunoDTO salvar(AlunoDTO aluno) throws CustomException;

    AlunoDTO deletar(Long id) throws CustomException;

}
