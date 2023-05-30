package com.alunoonline.api.model.service.impl;

import com.alunoonline.api.model.entidade.Disciplina;
import com.alunoonline.api.model.entidade.Professor;
import com.alunoonline.api.model.entidade.dto.DisciplinaDTO;
import com.alunoonline.api.model.entidade.dto.ProfessorDTO;
import com.alunoonline.api.model.exception.CustomException;
import com.alunoonline.api.model.exception.DefaultException;
import com.alunoonline.api.model.repository.DisciplinaRepository;
import com.alunoonline.api.model.utilities.AlunoOnlineValidacoes;
import com.alunoonline.api.model.repository.ProfessorRepository;
import com.alunoonline.api.model.service.ProfessorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.alunoonline.api.model.exception.DefaultException.ifTrueThrowException;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProfessorDTO> listarTodos() {

        List<ProfessorDTO> listaTodosDTO = new ArrayList<>();
        List<Professor> listaTodos = professorRepository.findAll();

        listaTodos.forEach(professor -> listaTodosDTO.add(modelMapper.map(professor, ProfessorDTO.class)));

        return listaTodosDTO;
    }

    @Override
    public ProfessorDTO buscarPorId(Long id) {

        Optional<Professor> professor = professorRepository.findById(id);

        return !professor.isPresent()
                ? ProfessorDTO.builder().build()
                : modelMapper.map(professor.get(), ProfessorDTO.class);
    }

    @Override
    public ProfessorDTO salvar(ProfessorDTO disciplinaDTO) {

        Optional<Professor> disciplina = professorRepository.findById(disciplinaDTO.getId());

        Professor professorAlterado = disciplina.orElseGet(Professor::new);
        professorAlterado.setNome(disciplinaDTO.getNome());
        professorAlterado.setEmail(disciplinaDTO.getEmail());
        professorRepository.save(professorAlterado);

        return modelMapper.map(professorAlterado, ProfessorDTO.class);
    }

    @Override
    public ProfessorDTO deletar(Long id) throws CustomException {

        Optional<Professor> professor = professorRepository.findById(id);

        ifTrueThrowException(!professor.isPresent(), AlunoOnlineValidacoes.ERRO_NAO_EXISTE);

        Professor professorDeletado = professor.get();
        professorRepository.delete(professorDeletado);

        return modelMapper.map(professorDeletado, ProfessorDTO.class);
    }

    @Override
    public List<Disciplina> obterDisciplinas(Long id) throws CustomException {

        Optional<Professor> optionalProfessor = professorRepository.findById(id);

        ifTrueThrowException(!optionalProfessor.isPresent(), AlunoOnlineValidacoes.ERRO_NAO_EXISTE);

        return disciplinaRepository.findAllByProfessor(optionalProfessor.get());

    }
}
