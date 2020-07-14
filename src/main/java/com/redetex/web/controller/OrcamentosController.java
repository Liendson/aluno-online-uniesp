package com.redetex.web.controller;

import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.entidade.dto.OrcamentoDTO;
import com.redetex.web.model.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orcamentos")
public class OrcamentosController {

    @Autowired
    private OrcamentoService orcamentoService;

    @GetMapping(value = "/buscar")
    public ResponseEntity<List<OrcamentoDTO>> buscarTodosOrcamentos() {
        return new ResponseEntity<>(orcamentoService.listarTodosOrcamentos(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/{idOrcamento}")
    public ResponseEntity<OrcamentoDTO> buscarOrcamento(@PathVariable Long idOrcamento) {
        return new ResponseEntity<>(orcamentoService.listarOrcamento(idOrcamento), HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<OrcamentoDTO> salvarOrcamento(@RequestBody OrcamentoDTO orcamento) {
        return new ResponseEntity<>(orcamentoService.salvarOrcamento(orcamento), HttpStatus.OK);
    }

    @GetMapping(value = "/cancelar/{idOrcamento}")
    public ResponseEntity<OrcamentoDTO> cancelarOrcamento(@PathVariable Long idOrcamento) {
        return new ResponseEntity<>(orcamentoService.cancelarOrcamento(idOrcamento), HttpStatus.OK);
    }
}
