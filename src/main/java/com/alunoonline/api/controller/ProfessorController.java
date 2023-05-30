package com.alunoonline.api.controller;

import com.alunoonline.api.model.entidade.Disciplina;
import com.alunoonline.api.model.entidade.dto.DisciplinaDTO;
import com.alunoonline.api.model.entidade.dto.ProfessorDTO;
import com.alunoonline.api.model.exception.CustomException;
import com.alunoonline.api.model.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping(value = "/buscar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProfessorDTO>> buscarTodos() {
        return ResponseEntity.ok(professorService.listarTodos());
    }

    @GetMapping(value = "/buscar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProfessorDTO> buscarPorId(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(professorService.buscarPorId(id));
    }

    @PostMapping(value = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfessorDTO> salvar(@RequestBody ProfessorDTO professorDTO) throws CustomException {
        return ResponseEntity.ok(professorService.salvar(professorDTO));
    }

    @PatchMapping(value = "/atualizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ProfessorDTO> atualizar(@RequestBody ProfessorDTO professorDTO) throws CustomException {
        return ResponseEntity.ok(professorService.salvar(professorDTO));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ProfessorDTO> deletar(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(professorService.deletar(id));
    }

    @GetMapping(value = "/listar-disciplinas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Disciplina>> obterDisciplinas(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(professorService.obterDisciplinas(id));
    }

}
