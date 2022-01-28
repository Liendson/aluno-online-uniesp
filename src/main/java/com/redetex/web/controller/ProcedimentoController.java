package com.redetex.web.controller;

import com.redetex.web.model.entidade.dto.ProcedimentoDTO;
import com.redetex.web.model.exception.CustomException;
import com.redetex.web.model.service.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoService procedimentoService;

    @GetMapping(value = "/buscar-procedimentos-hoje")
    public ResponseEntity<List<ProcedimentoDTO>> buscarTodosProcedimentosHoje() throws CustomException {
        return ResponseEntity.ok(procedimentoService.listarProcedimentosParaHoje());
    }

    @GetMapping(value = "/buscar-procedimentos-semana")
    public ResponseEntity<List<ProcedimentoDTO>> buscarTodosProcedimentosSemana() throws CustomException {
        return ResponseEntity.ok(procedimentoService.listarProcedimentosParaSemana());
    }
}
