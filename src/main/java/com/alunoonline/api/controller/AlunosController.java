package com.alunoonline.api.controller;

import com.alunoonline.api.model.entidade.dto.AlunoDTO;
import com.alunoonline.api.model.exception.CustomException;
import com.alunoonline.api.model.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping(value = "/buscar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AlunoDTO>> buscarTodos() {
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping(value = "/buscar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AlunoDTO> buscarPorId(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @PostMapping(value = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AlunoDTO> salvar(@RequestBody AlunoDTO alunoDTO) throws CustomException {
        return ResponseEntity.ok(alunoService.salvar(alunoDTO));
    }

    @PatchMapping(value = "/atualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AlunoDTO> atualizar(@RequestBody AlunoDTO alunoDTO) throws CustomException {
        return ResponseEntity.ok(alunoService.salvar(alunoDTO));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<AlunoDTO> deletar(@PathVariable Long id) throws CustomException {
        return ResponseEntity.ok(alunoService.deletar(id));
    }

}
