package com.redetex.web.controller;

import com.redetex.web.model.entidade.Servico;
import com.redetex.web.model.entidade.dto.ServicoDTO;
import com.redetex.web.model.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servicos")
public class ServicosController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping(value = "/buscar")
    public ResponseEntity<List<ServicoDTO>> buscarTodosServicos() {
        return new ResponseEntity<>(servicoService.listarTodosServicos(), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/{idServico}")
    public ResponseEntity<ServicoDTO> buscarServico(@PathVariable Long idServico) {
        return new ResponseEntity<>(servicoService.listarServico(idServico), HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<ServicoDTO> salvarServico(@RequestBody ServicoDTO servico) {
        return new ResponseEntity<>(servicoService.salvarServico(servico), HttpStatus.OK);
    }

    @GetMapping(value = "/cancelar/{idServico}")
    public ResponseEntity<ServicoDTO> cancelarServico(@PathVariable Long idServico) {
        return new ResponseEntity<>(servicoService.cancelarServico(idServico), HttpStatus.OK);
    }
}
