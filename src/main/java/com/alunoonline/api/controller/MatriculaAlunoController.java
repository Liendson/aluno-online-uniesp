package com.alunoonline.api.controller;

import com.alunoonline.api.model.entidade.dto.MatriculaAlunoDTO;
import com.alunoonline.api.model.exception.CustomException;
import com.alunoonline.api.model.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaAlunoController {

    @Autowired
    private MatriculaAlunoService matriculaAlunoService;

    @GetMapping(value = "/buscar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MatriculaAlunoDTO>> buscarTodos() {
        return ResponseEntity.ok(matriculaAlunoService.listarTodos());
    }

    @GetMapping(value = "/buscar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MatriculaAlunoDTO> buscarPorId(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(matriculaAlunoService.buscarPorId(id));
    }

    @PostMapping(value = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaAlunoDTO> salvar(@RequestBody MatriculaAlunoDTO matriculaAlunoDTO) throws CustomException {
        return ResponseEntity.ok(matriculaAlunoService.salvar(matriculaAlunoDTO));
    }

    @PatchMapping(value = "/atualizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<MatriculaAlunoDTO> atualizar(@RequestBody MatriculaAlunoDTO matriculaAlunoDTO) throws CustomException {
        return ResponseEntity.ok(matriculaAlunoService.salvar(matriculaAlunoDTO));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<MatriculaAlunoDTO> deletar(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(matriculaAlunoService.deletar(id));
    }
}
