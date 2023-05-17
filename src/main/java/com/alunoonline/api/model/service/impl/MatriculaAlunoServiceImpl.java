package com.alunoonline.api.model.service.impl;

import com.alunoonline.api.model.entidade.MatriculaAluno;
import com.alunoonline.api.model.entidade.dto.AlunoDTO;
import com.alunoonline.api.model.entidade.dto.MatriculaAlunoDTO;
import com.alunoonline.api.model.exception.CustomException;
import com.alunoonline.api.model.exception.DefaultException;
import com.alunoonline.api.model.utilities.AlunoOnlineValidacoes;
import com.alunoonline.api.model.repository.MatriculaAlunoRepository;
import com.alunoonline.api.model.service.MatriculaAlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MatriculaAlunoServiceImpl implements MatriculaAlunoService {

    @Autowired
    private MatriculaAlunoRepository matriculaAlunoRepository;

    @Autowired
    private ModelMapper modelMapper;

    static final Double notaMinima = 7.00;

    @Override
    public List<MatriculaAlunoDTO> listarTodos() {

        List<MatriculaAlunoDTO> listaTodosDTO = new ArrayList<>();
        List<MatriculaAluno> listaTodos = matriculaAlunoRepository.findAll();

        listaTodos.forEach(matriculaAluno ->
                listaTodosDTO.add(modelMapper.map(matriculaAluno, MatriculaAlunoDTO.class)));

        return listaTodosDTO;
    }

    @Override
    public MatriculaAlunoDTO buscarPorId(Long id) {

        Optional<MatriculaAluno> matriculaAluno = matriculaAlunoRepository.findById(id);

        return !matriculaAluno.isPresent()
                ? MatriculaAlunoDTO.builder().build()
                : modelMapper.map(matriculaAluno.get(), MatriculaAlunoDTO.class);
    }

    @Override
    public MatriculaAlunoDTO salvar(MatriculaAlunoDTO matriculaAlunoDTO) {

        Optional<MatriculaAluno> matricula = matriculaAlunoRepository.findById(matriculaAlunoDTO.getId());

        MatriculaAluno matriculaAlterada = matricula.orElseGet(MatriculaAluno::new);
        matriculaAlterada.setAluno(matriculaAlunoDTO.getAluno());
        matriculaAlterada.setStatus(matriculaAlunoDTO.getStatus());
        matriculaAlterada.setDisciplina(matriculaAlunoDTO.getDisciplina());
        matriculaAlterada.setNota1(matriculaAlunoDTO.getNota1());
        matriculaAlterada.setNota2(matriculaAlunoDTO.getNota2());
        matriculaAlunoRepository.save(matriculaAlterada);

        return modelMapper.map(matriculaAlterada, MatriculaAlunoDTO.class);
    }

    @Override
    public MatriculaAlunoDTO deletar(Long id) throws CustomException {

        Optional<MatriculaAluno> matriculaAluno = matriculaAlunoRepository.findById(id);

        DefaultException.ifTrueThrowException(!matriculaAluno.isPresent(), AlunoOnlineValidacoes.ERRO_CLIENTE_NAO_EXISTE);

        MatriculaAluno matriculaDeletada = matriculaAluno.get();
        matriculaAlunoRepository.delete(matriculaDeletada);

        return modelMapper.map(matriculaDeletada, MatriculaAlunoDTO.class);
    }

    public void atualizarNotas(MatriculaAlunoDTO matriculaAlunoDTO) {
        matriculaAlunoRepository.findById(matriculaAlunoDTO.getAluno().getId()).ifPresent(matriculaAluno -> {
            if (Objects.nonNull(matriculaAlunoDTO.getNota1()) && Objects.nonNull(matriculaAlunoDTO.getNota2())) {
                matriculaAluno.setNota1(matriculaAlunoDTO.getNota1());
                matriculaAluno.setNota2(matriculaAlunoDTO.getNota2());
                matriculaAluno.setStatus((matriculaAluno.getNota1() + matriculaAluno.getNota2()) / 2 >= notaMinima
                        ? "APROVADO"
                        : "REPROVADO");
                matriculaAlunoRepository.save(matriculaAluno);
            }
        });
    }
}
