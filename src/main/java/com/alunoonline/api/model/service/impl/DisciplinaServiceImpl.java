package com.alunoonline.api.model.service.impl;

import com.alunoonline.api.model.entidade.Disciplina;
import com.alunoonline.api.model.entidade.dto.DisciplinaDTO;
import com.alunoonline.api.model.exception.CustomException;
import com.alunoonline.api.model.exception.DefaultException;
import com.alunoonline.api.model.service.DisciplinaService;
import com.alunoonline.api.model.utilities.AlunoOnlineValidacoes;
import com.alunoonline.api.model.repository.DisciplinaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DisciplinaDTO> listarTodos() {

        List<DisciplinaDTO> listaTodosDTO = new ArrayList<>();
        List<Disciplina> listaTodos = disciplinaRepository.findAll();

        listaTodos.forEach(disciplina -> listaTodosDTO.add(modelMapper.map(disciplina, DisciplinaDTO.class)));

        return listaTodosDTO;
    }

    @Override
    public DisciplinaDTO buscarPorId(Long id) {

        Optional<Disciplina> aluno = disciplinaRepository.findById(id);

        return !aluno.isPresent()
                ? DisciplinaDTO.builder().build()
                : modelMapper.map(aluno.get(), DisciplinaDTO.class);
    }

    @Override
    public DisciplinaDTO salvar(DisciplinaDTO disciplinaDTO) {

        Optional<Disciplina> disciplina = disciplinaRepository.findById(disciplinaDTO.getId());

        Disciplina disciplinaAlterada = disciplina.orElseGet(Disciplina::new);
        disciplinaAlterada.setNome(disciplinaDTO.getNome());
        disciplinaAlterada.setProfessor(disciplinaDTO.getProfessor());
        disciplinaRepository.save(disciplinaAlterada);

        return modelMapper.map(disciplinaAlterada, DisciplinaDTO.class);
    }

    @Override
    public DisciplinaDTO deletar(Long id) throws CustomException {

        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);

        DefaultException.ifTrueThrowException(!disciplina.isPresent(), AlunoOnlineValidacoes.ERRO_CLIENTE_NAO_EXISTE);

        Disciplina disciplinaDeletada = disciplina.get();
        disciplinaRepository.delete(disciplinaDeletada);

        return modelMapper.map(disciplinaDeletada, DisciplinaDTO.class);
    }
}
