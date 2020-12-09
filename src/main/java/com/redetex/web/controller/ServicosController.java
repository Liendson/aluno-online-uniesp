package com.redetex.web.controller;

import com.redetex.web.model.entidade.dto.ServicoDTO;
import com.redetex.web.model.exception.CustomException;
import com.redetex.web.model.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

    @Autowired private ServicoService servicoService;

    @GetMapping(value = "/buscar")
    public ResponseEntity<List<ServicoDTO>> buscarTodosServicos() {
        return ResponseEntity.ok(servicoService.listarTodosServicos());
    }

    @GetMapping(value = "/buscar/{idServico}")
    public ResponseEntity<ServicoDTO> buscarServico(@PathVariable Integer idServico) {
        return ResponseEntity.ok(servicoService.detalharServico(idServico));
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<ServicoDTO> salvarServico(@RequestBody ServicoDTO servico) throws CustomException {
        return ResponseEntity.ok(servicoService.salvarServico(servico));
    }

    @GetMapping(value = "/cancelar/{idServico}")
    public ResponseEntity<ServicoDTO> cancelarServico(@PathVariable Integer idServico) throws CustomException {
        return ResponseEntity.ok(servicoService.cancelarServico(idServico));
    }
}
