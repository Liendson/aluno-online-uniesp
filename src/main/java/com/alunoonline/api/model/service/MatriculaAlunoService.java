package com.alunoonline.api.model.service;

import com.alunoonline.api.model.entidade.dto.AtualizarNotasDTO;
import com.alunoonline.api.model.entidade.dto.HistoricoAlunoDto;
import com.alunoonline.api.model.entidade.dto.MatriculaAlunoDTO;
import com.alunoonline.api.model.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatriculaAlunoService {

    List<MatriculaAlunoDTO> listarTodos();

    MatriculaAlunoDTO buscarPorId(Long id) throws CustomException;

    MatriculaAlunoDTO salvar(MatriculaAlunoDTO matriculaAlunoDTO) throws CustomException;

    MatriculaAlunoDTO deletar(Long id) throws CustomException;

    void atualizarNotas(AtualizarNotasDTO matriculaAlunoDTO) throws CustomException;

    void trancarMatricula(Long idMatriculaAluno) throws CustomException;

    HistoricoAlunoDto emitirHistoricoDoAluno(Long idAluno) throws CustomException;

}
