package com.alunoonline.api.model.service.impl;

import com.alunoonline.api.model.entidade.Aluno;
import com.alunoonline.api.model.entidade.dto.AlunoDTO;
import com.alunoonline.api.model.exception.CustomException;
import com.alunoonline.api.model.exception.DefaultException;
import com.alunoonline.api.model.utilities.AlunoOnlineValidacoes;
import com.alunoonline.api.model.repository.AlunoRepository;
import com.alunoonline.api.model.service.AlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AlunoDTO> listarTodos() {

        List<AlunoDTO> listaTodosDTO = new ArrayList<>();
        List<Aluno> listaTodos = alunoRepository.findAll();

        listaTodos.forEach(aluno -> listaTodosDTO.add(modelMapper.map(aluno, AlunoDTO.class)));

        return listaTodosDTO;
    }

    @Override
    public AlunoDTO buscarPorId(Long id) {

        Optional<Aluno> aluno = alunoRepository.findById(id);

        return !aluno.isPresent()
                ? AlunoDTO.builder().build()
                : modelMapper.map(aluno.get(), AlunoDTO.class);
    }

    @Override
    public AlunoDTO salvar(AlunoDTO alunoDTO) {

        Optional<Aluno> aluno = alunoRepository.findById(alunoDTO.getId());

        Aluno alunoAlterado = aluno.orElseGet(Aluno::new);
        alunoAlterado.setNome(alunoDTO.getNome());
        alunoAlterado.setCurso(alunoDTO.getCurso());
        alunoAlterado.setEmail(alunoDTO.getEmail());
        alunoRepository.save(alunoAlterado);

        return modelMapper.map(alunoAlterado, AlunoDTO.class);
    }

    @Override
    public AlunoDTO deletar(Long id) throws CustomException {

        Optional<Aluno> aluno = alunoRepository.findById(id);

        DefaultException.ifTrueThrowException(!aluno.isPresent(), AlunoOnlineValidacoes.ERRO_NAO_EXISTE);

        Aluno alunoDeletado = aluno.get();
        alunoRepository.delete(alunoDeletado);

        return modelMapper.map(alunoDeletado, AlunoDTO.class);
    }

}
