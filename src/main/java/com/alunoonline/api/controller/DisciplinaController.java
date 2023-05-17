package com.alunoonline.api.controller;

import com.alunoonline.api.model.entidade.dto.DisciplinaDTO;
import com.alunoonline.api.model.exception.CustomException;
import com.alunoonline.api.model.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping(value = "/buscar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<DisciplinaDTO>> buscarTodos() {
        return ResponseEntity.ok(disciplinaService.listarTodos());
    }

    @GetMapping(value = "/buscar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DisciplinaDTO> buscarPorId(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(disciplinaService.buscarPorId(id));
    }

    @PostMapping(value = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DisciplinaDTO> salvar(@RequestBody DisciplinaDTO disciplinaDTO) throws CustomException {
        return ResponseEntity.ok(disciplinaService.salvar(disciplinaDTO));
    }

    @PatchMapping(value = "/atualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DisciplinaDTO> atualizar(@RequestBody DisciplinaDTO disciplinaDTO) throws CustomException {
        return ResponseEntity.ok(disciplinaService.salvar(disciplinaDTO));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<DisciplinaDTO> deletar(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(disciplinaService.deletar(id));
    }

}
