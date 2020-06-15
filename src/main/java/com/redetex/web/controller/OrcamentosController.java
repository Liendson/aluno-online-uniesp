package com.redetex.web.controller;

import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orcamentos")
public class OrcamentosController {

    @Autowired
    private OrcamentoService orcamentoService;

    @GetMapping(value = "/buscar")
    public List<Orcamento> buscarTodosOrcamentos() {
        return orcamentoService.listarTodosOrcamentos();
    }

    @GetMapping(value = "/buscar/{idOrcamento}")
    public Orcamento buscarOrcamento(@PathVariable Long idOrcamento) {
        return orcamentoService.listarOrcamento(idOrcamento);
    }

    @PostMapping(value = "/salvar")
    public void salvarOrcamento(@RequestBody Orcamento orcamento) {
        orcamentoService.salvarOrcamento(orcamento);
    }

    @GetMapping(value = "/cancelar/{idOrcamento}")
    public void cancelarOrcamento(@PathVariable Long idOrcamento) {
        orcamentoService.cancelarOrcamento(idOrcamento);
    }
}
