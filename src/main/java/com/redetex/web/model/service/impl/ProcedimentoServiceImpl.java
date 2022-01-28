package com.redetex.web.model.service.impl;

import com.redetex.web.model.entidade.Orcamento;
import com.redetex.web.model.entidade.Servico;
import com.redetex.web.model.entidade.dto.ProcedimentoDTO;
import com.redetex.web.model.enums.TipoProcedimentoEnum;
import com.redetex.web.model.service.OrcamentoService;
import com.redetex.web.model.service.ProcedimentoService;
import com.redetex.web.model.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcedimentoServiceImpl implements ProcedimentoService {

    @Autowired
    private OrcamentoService orcamentoService;
    @Autowired
    private ServicoService servicoService;

    @Override
    public List<ProcedimentoDTO> listarProcedimentosParaHoje() {

        List<ProcedimentoDTO> listaDeProcedimentos = new ArrayList<>();
        List<Orcamento> listaDeOrcamentos = orcamentoService.getRepository().findAllOrcamentosParaHoje();
        List<Servico> listaDeServicos = servicoService.getRepository().findAllServicosParaHoje();

        listaDeOrcamentos.forEach(orcamento -> {
            ProcedimentoDTO procedimentoDTO =
                    ProcedimentoDTO.builder()
                            .id(orcamento.getIdOrcamento())
                            .tipoProcedimento(TipoProcedimentoEnum.ORCAMENTO)
                            .tipoProduto(orcamento.getTipoOrcamento())
                            .cliente(orcamento.getClienteOrcamento())
                            .situacao(orcamento.getSituacaoOrcamento())
                            .valor(orcamento.getValorOrcamento())
                            .observacao(orcamento.getObservacaoOrcamento())
                            .endereco(orcamento.getEnderecoOrcamento())
                            .medidas(orcamento.getMedidasOrcamento())
                            .dataProcedimento(orcamento.getDataOrcamento())
                            .build();

            listaDeProcedimentos.add(procedimentoDTO);
        });

        listaDeServicos.forEach(servico -> {
            ProcedimentoDTO procedimentoDTO =
                    ProcedimentoDTO.builder()
                            .id(servico.getIdServico())
                            .tipoProcedimento(TipoProcedimentoEnum.SERVICO)
                            .tipoProduto(servico.getOrcamentoServico().getTipoOrcamento())
                            .cliente(servico.getOrcamentoServico().getClienteOrcamento())
                            .situacao(servico.getSituacaoServico())
                            .valor(servico.getOrcamentoServico().getValorOrcamento())
                            .observacao(servico.getObservacaoServico())
                            .endereco(servico.getOrcamentoServico().getEnderecoOrcamento())
                            .medidas(servico.getOrcamentoServico().getMedidasOrcamento())
                            .dataProcedimento(servico.getDataInstalacaoServico())
                            .build();

            listaDeProcedimentos.add(procedimentoDTO);
        });

        return listaDeProcedimentos;
    }

    @Override
    public List<ProcedimentoDTO> listarProcedimentosParaSemana() {

        List<ProcedimentoDTO> listaDeProcedimentos = new ArrayList<>();
        List<Orcamento> listaDeOrcamentos = orcamentoService.getRepository().findAllOrcamentosParaSemana();
        List<Servico> listaDeServicos = servicoService.getRepository().findAllServicosParaSemana();

        listaDeOrcamentos.forEach(orcamento -> {
            ProcedimentoDTO procedimentoDTO =
                    ProcedimentoDTO.builder()
                            .id(orcamento.getIdOrcamento())
                            .tipoProcedimento(TipoProcedimentoEnum.ORCAMENTO)
                            .tipoProduto(orcamento.getTipoOrcamento())
                            .cliente(orcamento.getClienteOrcamento())
                            .situacao(orcamento.getSituacaoOrcamento())
                            .valor(orcamento.getValorOrcamento())
                            .observacao(orcamento.getObservacaoOrcamento())
                            .endereco(orcamento.getEnderecoOrcamento())
                            .medidas(orcamento.getMedidasOrcamento())
                            .dataProcedimento(orcamento.getDataOrcamento())
                            .build();

            listaDeProcedimentos.add(procedimentoDTO);
        });

        listaDeServicos.forEach(servico -> {
            ProcedimentoDTO procedimentoDTO =
                    ProcedimentoDTO.builder()
                            .id(servico.getIdServico())
                            .tipoProcedimento(TipoProcedimentoEnum.SERVICO)
                            .tipoProduto(servico.getOrcamentoServico().getTipoOrcamento())
                            .cliente(servico.getOrcamentoServico().getClienteOrcamento())
                            .situacao(servico.getSituacaoServico())
                            .valor(servico.getOrcamentoServico().getValorOrcamento())
                            .observacao(servico.getObservacaoServico())
                            .endereco(servico.getOrcamentoServico().getEnderecoOrcamento())
                            .medidas(servico.getOrcamentoServico().getMedidasOrcamento())
                            .dataProcedimento(servico.getDataInstalacaoServico())
                            .build();

            listaDeProcedimentos.add(procedimentoDTO);
        });

        return listaDeProcedimentos;
    }
}
