package com.alunoonline.api.model.service.impl;

import com.alunoonline.api.model.entidade.MatriculaAluno;
import com.alunoonline.api.model.entidade.dto.AtualizarNotasDTO;
import com.alunoonline.api.model.entidade.dto.HistoricoAlunoDto;
import com.alunoonline.api.model.entidade.dto.HistoricoDisciplinaDTO;
import com.alunoonline.api.model.entidade.dto.MatriculaAlunoDTO;
import com.alunoonline.api.model.exception.CustomException;
import com.alunoonline.api.model.repository.MatriculaAlunoRepository;
import com.alunoonline.api.model.service.MatriculaAlunoService;
import com.alunoonline.api.model.utilities.AlunoOnlineValidacoes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.alunoonline.api.model.exception.DefaultException.ifTrueThrowException;

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
        matriculaAlterada.setNota1(matriculaAlunoDTO.getPrimeiraNota());
        matriculaAlterada.setNota2(matriculaAlunoDTO.getSegundaNota());
        matriculaAlunoRepository.save(matriculaAlterada);

        return modelMapper.map(matriculaAlterada, MatriculaAlunoDTO.class);
    }

    @Override
    public MatriculaAlunoDTO deletar(Long id) throws CustomException {

        Optional<MatriculaAluno> matriculaAluno = matriculaAlunoRepository.findById(id);

        ifTrueThrowException(!matriculaAluno.isPresent(), AlunoOnlineValidacoes.ERRO_NAO_EXISTE);

        MatriculaAluno matriculaDeletada = matriculaAluno.get();
        matriculaAlunoRepository.delete(matriculaDeletada);

        return modelMapper.map(matriculaDeletada, MatriculaAlunoDTO.class);
    }

    @Override
    public void atualizarNotas(AtualizarNotasDTO matriculaAlunoDTO) throws CustomException {
        Optional<MatriculaAluno> optionalMatricula =
                matriculaAlunoRepository.findById(matriculaAlunoDTO.getIdMatriculaAluno());
        ifTrueThrowException(!optionalMatricula.isPresent(), AlunoOnlineValidacoes.ERRO_NAO_EXISTE);
        optionalMatricula.ifPresent(matriculaAluno -> {
            if (Objects.nonNull(matriculaAlunoDTO.getPrimeiraNota()) && Objects.nonNull(matriculaAlunoDTO.getSegundaNota())) {
                matriculaAluno.setNota1(matriculaAlunoDTO.getPrimeiraNota());
                matriculaAluno.setNota2(matriculaAlunoDTO.getSegundaNota());
                matriculaAluno.setStatus((matriculaAluno.getNota1() + matriculaAluno.getNota2()) / 2 >= notaMinima
                        ? "APROVADO"
                        : "REPROVADO");
                matriculaAlunoRepository.save(matriculaAluno);
            }
        });
    }

    @Override
    public void trancarMatricula(Long idMatriculaAluno) throws CustomException {
        Optional<MatriculaAluno> optionalMatricula = matriculaAlunoRepository.findById(idMatriculaAluno);
        ifTrueThrowException(!optionalMatricula.isPresent(), AlunoOnlineValidacoes.ERRO_NAO_EXISTE);
        optionalMatricula.ifPresent(matriculaAluno -> {
            if (matriculaAluno.getStatus().equals("MATRICULADO")
                    || Objects.isNull(matriculaAluno.getNota2())) {
                matriculaAluno.setStatus("TRANCADO");
                matriculaAlunoRepository.save(matriculaAluno);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        AlunoOnlineValidacoes.ERRO_NAO_E_POSSIVEL_TRANCAR_MATRICULA.getTexto());
            }
        });
    }

    @Override
    public HistoricoAlunoDto emitirHistoricoDoAluno(Long idAluno) throws CustomException {
        List<MatriculaAluno> matriculaAlunos = matriculaAlunoRepository.findByAlunoId(idAluno);

        if (!matriculaAlunos.isEmpty()) {
            String nomeDoAluno = matriculaAlunos.get(0).getAluno().getNome();
            String nomeDoCurso = matriculaAlunos.get(0).getAluno().getCurso();
            List<HistoricoDisciplinaDTO> listaDeDisciplinas =
                    matriculaAlunos.stream().map(matriculaAluno ->
                                    HistoricoDisciplinaDTO.builder()
                                            .id(matriculaAluno.getId())
                                            .primeiraNota(matriculaAluno.getNota1())
                                            .segundaNota(matriculaAluno.getNota2())
                                            .media(calcularMediaAluno(matriculaAluno))
                                            .status(matriculaAluno.getStatus())
                                            .nome(matriculaAluno.getDisciplina().getNome())
                                            .build())
                            .collect(Collectors.toList());

            return HistoricoAlunoDto.builder()
                    .nomeAluno(nomeDoAluno)
                    .cursoAluno(nomeDoCurso)
                    .disciplinaDTOList(listaDeDisciplinas)
                    .build();
        } else {
            throw new CustomException(AlunoOnlineValidacoes.ERRO_ALUNO_NAO_POSSUI_MATRICULAS);
        }

    }

    public Double calcularMediaAluno(MatriculaAluno matriculaAluno) {
        return Objects.nonNull(matriculaAluno.getNota1()) && Objects.nonNull(matriculaAluno.getNota2())
                ? (matriculaAluno.getNota1() + matriculaAluno.getNota2()) / 2 : null;
    }
}
