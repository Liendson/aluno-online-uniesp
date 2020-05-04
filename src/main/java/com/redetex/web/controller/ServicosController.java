package com.redetex.web.controller;

import com.redetex.web.model.entidade.Servico;
import com.redetex.web.model.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("servicos")
public class ServicosController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping(value = "/buscar")
    public List<Servico> buscarTodosServicos() {
        return servicoService.listarTodosServicos();
    }

    @GetMapping(value = "/buscar/{idServico}")
    public Servico buscarServico(@PathVariable Long idServico) {
        return servicoService.listarServico(idServico);
    }

    @PostMapping(value = "/salvar")
    public void salvarServico(@RequestBody Servico servico) {
        servicoService.salvarServico(servico);
    }

    @GetMapping(value = "/cancelar/{idServico}")
    public void cancelarServico(@PathVariable Long idServico) {
        servicoService.cancelarServico(idServico);
    }
}
